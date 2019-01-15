package com.itheima.web.servlet;

import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题
        //获得激活码
        String activeCode = request.getParameter("activeCode");

        UserService service = new UserService();
        service.active(activeCode);

        //跳转到登陆界面
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

}
