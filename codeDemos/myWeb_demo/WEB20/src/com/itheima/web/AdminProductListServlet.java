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

@WebServlet(name = "AdminProductListServlet", urlPatterns = "/adminProductList")
public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        //        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        //传递请求到 Service 层
        AdminProductService service = new AdminProductService();
        List<Product> productList =null;
        try {
            productList = service.findAllProducts();
//            System.out.println(productList[0].getName());
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

        //将ProductList 放到 request 域
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("admin/product/list.jsp").forward(request,response);
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}