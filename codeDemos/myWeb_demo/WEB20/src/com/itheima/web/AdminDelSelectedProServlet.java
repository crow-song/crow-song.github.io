package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminDelSelectedProServlet", urlPatterns = "/adminDelSelectedPro")
public class AdminDelSelectedProServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        request.getParameter();
//        String userIdListStr = request.getParameter("userIdList");
//        System.out.println(userIdListStr);
//        AdminProductService servie = new AdminProductService();
//        servie.delProductListByIds(userIdList);


//        String selected = new String<>();
//        String checkbox = request.getParameterMap("checkbox",selected);
//        System.out.println(checkbox);

    }
}