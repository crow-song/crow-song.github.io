package com.itheima.web;

import com.google.gson.Gson;
import com.itheima.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchWrodServlet", urlPatterns = "/searchWrod")
public class SearchWrodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获得关键字
        String keyword = request.getParameter("word");
        //获得有关键字的所有商品
        ProductService service = new ProductService();
        List<Object> productList = null;
        try {
            productList = service.findProductByWord(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String json = gson.toJson(productList);
        System.out.println(json);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }
}