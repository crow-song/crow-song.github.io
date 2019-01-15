package com.itheima.web.filter;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获得 cookie 中的用户名和密码
        HttpServletRequest request = (HttpServletRequest) req;
        EnhanceRequest enhanceRequest = new EnhanceRequest(request);
        //使用动态代理完成全局编码
//        HttpServletRequest enhanceRequest = (HttpServletRequest) Proxy.newProxyInstance(
//                req.getClass().getClassLoader(),
//                req.getClass().getInterfaces(),
//                new InvocationHandler(){
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        String name = method.getName();
//                        if("getParameter".equals(name)){
//                            String invoke = (String)method.invoke(request, args);
//                            invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");
//                            return invoke;
//                        }
//                        return method.invoke(req,args);
//                    }
//                }
//        );
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        String cookie_username=null;
        String cookie_password=null;
        if(cookies!=null){
            for(Cookie cookie:cookies){

                //获得名字是 cookie_username 和 cookiepassword 的 cookie 值
                if("cookie_username".equals(cookie.getName())){
                    cookie_username = cookie.getValue();
//                    把编码过的字符串变回中文
                    cookie_username = URLDecoder.decode(cookie_username, "UTF-8");
                }
                if("cookie_password".equals(cookie.getName())){
                    cookie_password=cookie.getValue();
                }
            }

        }

        //判断 username 和 password 是否为空
        if(cookie_username!=null&&cookie_password!=null){
            //登录代码
            UserService service = new UserService();
            User user = null;
            try {
                System.out.println("cookie_username="+cookie_username+" cookie_passoword="+cookie_password);
                user = service.login(cookie_username,cookie_password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //将 User 存到 Session 域
            if(user!=null){
                System.out.println("user 不为空，session name="+user.getUsername()+" session password="+user.getPassword());
                session.setAttribute("user",user);
            }
        }
        //将增强 request 参数传递给 servlet
        chain.doFilter(enhanceRequest, resp);
    }

    //增强 request 解决乱码问题
    class EnhanceRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        //设置 map 是否进行过转码
        boolean flag=false;
        public EnhanceRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
            System.out.println("EnhanceRequest 初始化 执行");
        }
        //对 getParameter 进行增强

        @Override
        public String getParameter(String name) {
            System.out.println("EnhanceRequest getParameter 执行");
            String parameter = request.getParameter(name);//未被增强
            //获取页面提交类型
            String method = request.getMethod();
            //判断提交类型选择解码方式
//        if("POST".equals(method)){
//            try {
//                request.setCharacterEncoding("UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
            if("GET".equals(method)){
                try {
                    System.out.println("get 提交");
                    parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return parameter;
        }
        public Map<String, String[]> getParameterMap(){
            //获得未被增强参数方法
            Map<String,String[]> map = request.getParameterMap();
            String method = request.getMethod();
            if("GET".equals(method))
                //获得当前提交方法
                try{
                    if(!flag) {
                        Set<Map.Entry<String, String[]>> entries = map.entrySet();
                        for (Map.Entry<String, String[]> entry : entries) {
                            String[] values = entry.getValue();
                            for (int i = 0; i < values.length; i++) {
                                values[i] = new String(values[i].getBytes("iso8859-1"), "UTF-8");
                            }
                        }
                        //转码过后 falg 为真，下次不再进入转码
                        flag=true;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            return map;

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
