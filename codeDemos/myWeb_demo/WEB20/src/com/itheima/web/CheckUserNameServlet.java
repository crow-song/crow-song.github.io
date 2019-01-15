package com.itheima.web;

import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckUserNameServlet", urlPatterns = "/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        //获得用户名
        String username = request.getParameter("username");
        //传递 username 到 service 层
        UserService service = new UserService();
        boolean isExist=false;
        try {
            isExist = service.checkUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.getWriter().write("{\"isExist\":" + isExist + "}");
    }
}