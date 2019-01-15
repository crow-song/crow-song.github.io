package com.itheima.attribute;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestMyServletContextAttributeServlet", urlPatterns = "/TestMyServletContextAttributeServlet")
public class TestMyServletContextAttributeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        //向 context 存数据
        context.setAttribute("name","zhangsan");
        //该数据
        context.setAttribute("name","lucy");
        //删除数据
        context.removeAttribute("name");
    }
}