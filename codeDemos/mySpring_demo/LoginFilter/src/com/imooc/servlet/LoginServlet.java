package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        //      如果有登录用户名，则放行
        if("admin".equals(username) && "admin".equals(password)){
            //校验通过
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }
        //      如果没有，则重定向返回至登录页面
        else{
            //校验失败
            response.sendRedirect(request.getContextPath()+"/failure.jsp");

        }
    }


}
