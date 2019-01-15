package com.itheima.web;

import com.itheima.domain.Category;
import com.itheima.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminCategoryListUIServlet", urlPatterns = "/adminCategoryListUI")
public class AdminCategoryListUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        //获得所有商品类别数据
        AdminProductService service = new AdminProductService();
        List<Category> categoryList = null;
        try {
            categoryList = service.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);

    }
}