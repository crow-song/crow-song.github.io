package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.*;
import com.itheima.service.ProductService;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.JedisPoolUtils;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductServlet extends BaseServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
//        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
//        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题
//        //获得请求方法的 method
//        String method = request.getParameter("method");
//        if("productListByCid".equals(method)){
//            productListByCid(request,response);
//        }else if("productInfo".equals(method)){
//            productInfo(request,response);
//        }else if("index".equals(method)){
//            index(request,response);
//        }else if("categoryList".equals(method)){
//            categoryList(request,response);
//        }
//
//    }
//    获得商品类别列表
    public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        ProductService service = new ProductService();

        //判断是否有缓存的 category 如果没有则从数据库中查询 category 并存储到缓存
//        获得 jedis 对象，连接 redis 数据库
        Jedis jedis = JedisPoolUtils.getJedis();
        String categoryListJson = jedis.get("categoryListJson");

        if(categoryListJson==null){
            System.out.println("缓存没数据，查询数据库");
            //准备分类数据
            List<Category> categoryList = service.findAllCategory();
            Gson gson = new Gson();
            categoryListJson = gson.toJson(categoryList);
            jedis.set("categoryListJson",categoryListJson);
        }

        response.getWriter().write(categoryListJson);
    }


//    显示首页/商品类别的功能
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")

        ProductService service = new ProductService();
        //准备热门商品List<Product>
        List<Product> hotProductList = service.findHotProductList();

        //准备最新商品List<Product>
        List<Product> newProductList = service.findNewProductList();

        //准备商品类别List<Category>
        List<Category> categoryList = service.findAllCategory();

        request.setAttribute("hotProductList",hotProductList);
        request.setAttribute("newProductList",newProductList);
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }


    //显示商品的详细信息
    public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题
        String pid = request.getParameter("pid");
        String cid = request.getParameter("cid");
        String currentPage = request.getParameter("currentPage");

        ProductService service = new ProductService();
        Product product = service.findProductByPid(pid);

        //获得客户端携带的 cookies --获得名字是 pids 的 cookie value
        String pids= pid;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("pids".equals(cookie.getName())){
                    pids = cookie.getValue();//获得 cookie key 为 pid 的 value
                    String[] split = pids.split("-");
                    List<String> asList = Arrays.asList(split);
                    LinkedList<String> list = new LinkedList<String>(asList);

                    if(list.contains(pid)){
                        //如果原来的 cookie 含有 pid 则删除这个 pid
                        list.remove(pid);
                    }
                    //添加 新的 pid 到头部
                    list.addFirst(pid);

//                    拼接新的 cookie 格式：3-2-5-1
                    StringBuffer sb = new StringBuffer();
                    for(int i=0;i<list.size()&&i<7;i++){
                        sb.append(list.get(i));
                        sb.append("-");//3-2-1-
                    }
                    //去掉最后的 -
                    //长度为6，substring 包括头不包括尾 sb.substring(0,5) 最终为[0,5)
                    pids = sb.substring(0,sb.length()-1);

                }
            }
        }
        Cookie cookie_pids = new Cookie("pids",pids);
        response.addCookie(cookie_pids);

        //转发前创建 cookie

        request.setAttribute("product",product);
        request.setAttribute("cid",cid);
        request.setAttribute("currentPage",currentPage);
        request.getRequestDispatcher("/product_info.jsp").forward(request,response);


    }

    //根据商品的类别获得商品列表
    public void productListByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题
        String cid = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null || currentPageStr.trim().length() <= 0){
            currentPageStr="1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        int currentCount=12;

        ProductService service = new ProductService();
        PageBean pageBean = service.findProductByCid(cid,currentPage,currentCount);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("cid",cid);
        request.setAttribute("currentPage",currentPage);


        //定义一个记录历史商品信息的集合
        List<Product> historyProductList = new ArrayList<Product>();
        //获得客户端携带名字叫 pids 的 cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("pids".equals(cookie.getName())){
                    String pids = cookie.getValue();//3-1-2
                    String[] split = pids.split("-");
                    for(String pid:split){
                        Product productByPid = service.findProductByPid(pid);
                        historyProductList.add(productByPid);
                    }
                }
            }
        }
        //将历史纪录放到域中
        request.setAttribute("historyProductList",historyProductList);

        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
    public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();

        //获得要放到购物车的商品 pid/数量
        String pid = request.getParameter("pid");

        //获得该商品购买数量
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));

        //获得 product
        Product productByPid = service.findProductByPid(pid);

        //封装 CartItem
        CartItem cartItem = new CartItem();
        cartItem.setBuyNum(buyNum);
        cartItem.setProduct(productByPid);
        //计算小计
        double subtotal = productByPid.getShop_price()*buyNum;
        cartItem.setSubtotal(subtotal);

        //获得购物车
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        double newtotal = 0.0;
        if(cart==null){
            cart = new Cart();
        }
        //获得购物车中 Items 对象
        Map<String, CartItem> cartItems = cart.getCartItems();
        //如果购物车 session 已有该商品，则将原来的数量与现在的相加
        if(cartItems.containsKey(pid)){
            CartItem item = cartItems.get(pid);
            int oldNum = item.getBuyNum();
            oldNum += buyNum;
            item.setBuyNum(oldNum);
            cart.setCartItems(cartItems);

            //旧商品小计
            double oldtotal = item.getSubtotal();
            //新商品小计
            newtotal = buyNum*productByPid.getShop_price();
            //修改小计
            item.setSubtotal(oldtotal+newtotal);
        }else{
            //购物车中没有该商品
            cartItems.put(productByPid.getPid(),cartItem);
            newtotal = buyNum*productByPid.getShop_price();
        }


        //将购物项放入购物车
        //key 是 pid

        double total = cart.getTotal()+newtotal;

        cart.setTotal(total);

        session.setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart.jsp");

    }
    //删除购物车单一商品
    public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        HttpSession session = request.getSession();

        Cart cart = (Cart)session.getAttribute("cart");

        if(cart!=null){
            Map<String, CartItem> cartItems = cart.getCartItems();
            //修改总价
            double total = cart.getTotal() - cartItems.get(pid).getSubtotal();
            cart.setTotal(total);
            //删除该商品
            cartItems.remove(pid);
            cart.setCartItems(cartItems);
        }

        session.setAttribute("cart",cart);

        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }
    //清空购物车
    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }

    //提交订单
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        //判断用户是否登陆，如果未登录则不封装Order
        if(user==null){
            //没有登陆则跳回登录页
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //防止跳转后后面代码执行
            return;
        }

        //封装 Order
        Order order = new Order();

        Cart cart = (Cart)session.getAttribute("cart");
//        private String oid;//该订单的订单号
        String oid = CommonsUtils.getUUID();
        order.setOid(oid);
//        private Date ordertime;//下单时间 -- 如果不进行转换 会报异常 Incorrect datetime value: '' for column 'ordertime'
        Date date=new Date();
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date2=temp.format(date);
        Date date3= null;
        try {
            date3 = temp.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setOrdertime(date3);
//        order.setOrdertime(new Date());
//        private double total;//订单总价格
        order.setTotal(cart.getTotal());
//        private int state;//订单状态（已付款1，未付款0...）
        order.setState(0);
        //收货地址等参数需要后期表单填入，先设为空
//        private String addr;//收货地址
        order.setAddr(null);
//        private String name;//收货人
        order.setName(null);
//        private String telphone;//收获人的手机号
        order.setTelphone(null);
//        private User user;//订单属于哪个用户
        order.setUser(user);

        //List<OrderItem> orderItems = new ArrayList<OrderItem>();
        //该订单有多少订单项
        //先获得购物车的订单项，循环遍历取出并装进 Order
        Map<String, CartItem> cartItems = cart.getCartItems();
        for(Map.Entry<String,CartItem>entry: cartItems.entrySet()){
            //取出 entry 中的每个 CartItem 对象
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem();
//            private String itemid;//订单项的 id
            orderItem.setItemid(CommonsUtils.getUUID());
//            private int count;//订单项的商品购买个数
            orderItem.setCount(cartItem.getBuyNum());
//            private double subtotal;//订单项的小计
            orderItem.setSubtotal(cartItem.getSubtotal());
//            private Product product;//订单项内部的商品（外部的属性用对象表示）
            orderItem.setProduct(cartItem.getProduct());
//            private Order order;//该订单项属于哪个订单
            orderItem.setOrder(order);

            //将该订单项添加到订单的订单集合项中
            order.getOrderItems().add(orderItem);
        }

        //order 对象封装完毕
        ProductService service = new ProductService();
        service.submitOrder(order);

        session.setAttribute("order",order);

        //跳转页面到订单页面
        response.sendRedirect(request.getContextPath()+"/order_info.jsp");

    }

    //确认订单，更新收货人信息，在线支付
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Order order = new Order();
        try {
            BeanUtils.populate(order,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ProductService service = new ProductService();
        service.updateOrderAddr(order);

    }

    //获得当前用户订单
    public void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        //判断用户是否登陆，如果未登录则不封装Order
        if(user==null){
            //没有登陆则跳回登录页
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //防止跳转后后面代码执行
            return;
        }

        ProductService service = new ProductService();
        //查询该用户所有订单（单表查询 Order）
        //集合中的 Order 对象不完整--缺少 List<OrderItem> orderItems 数据
        List<Order> orderList = service.findAllOrders(user.getUid());

        //循环所有订单，为每个订单填充订单项
        if(orderList!=null) {
            for (Order order : orderList) {
                //获得每个 order 的 oid
                String oid = order.getOid();
                //查询该订单所有订单项--mapList 封装了多个订单项和该订单项中的商品信息
                List<Map<String, Object>> mapList = service.findAllOrderItemByOid(oid);
                //将 mapList 转换成 List<orderItem>orderItems
                for(Map<String,Object>map:mapList){

                    try {
                        OrderItem item = new OrderItem();
                        //map 中取出 count 封装到 OrderItem
                        BeanUtils.populate(item,map);
                        //map 中取出 pimage,pname,shop_price 封装到 Product
                        Product product = new Product();
                        BeanUtils.populate(product,map);
                        //将 Product 封装到 OrderItem
                        item.setProduct(product);
                        //将 OrderItem 封装到 order
                        order.getOrderItems().add(item);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }


        // OrderList 数据封装完成
        request.setAttribute("orderList",orderList);
        System.out.println(request.getContextPath());
        request.getRequestDispatcher("/order_list.jsp").forward(request,response);
    }
}
