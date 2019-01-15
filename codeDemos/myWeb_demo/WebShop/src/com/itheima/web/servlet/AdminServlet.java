package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.service.AdminService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;



//import org.apache.naming.factory.BeanFactory;

public class AdminServlet extends BaseServlet {
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //提供一个 Category json 字符串
        //使用解耦合方式进行编码--web 与 service 层
        //使用工厂+反射+配置文件xml
        AdminService service = (AdminService) BeanFactory.getBean("adminService");
        List<Category> categoryList =  service.findAllCategory();
        Gson gson = new Gson();
        String json = gson.toJson(categoryList);
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write(json);

    }
    //查询所有订单项
    public void findAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService service = (AdminService) BeanFactory.getBean("adminService");
        List<Order> orderList = service.findAllOrders();

        HttpSession session = request.getSession();
        session.setAttribute("orderList",orderList);
        request.getRequestDispatcher("admin/order/list.jsp").forward(request,response);
    }

    //查询订单详情
    public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String oid = request.getParameter("oid");
        AdminService service = (AdminService) BeanFactory.getBean("adminService");
        List<Map<String,Object>> mapList = service.findOrderInfoByOid(oid);
        Gson gson = new Gson();
        String json = gson.toJson(mapList);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }





}
