package com.itheima.web;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminUpdateProductUIServlet", urlPatterns = "/adminUpdateProductUI")
public class AdminUpdateProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        String pid = request.getParameter("pid");
        AdminProductService service = new AdminProductService();
        Product product = null;
        try {
            product = service.findProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获得所有商品类别数据
        List<Category> categoryList = null;
        try {
            categoryList = service.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //将商品类别 categoryList 放到 request 域
        request.setAttribute("categoryList",categoryList);

        request.setAttribute("product",product);
        request.getRequestDispatcher("admin/product/edit.jsp").forward(request,response);

    }
}