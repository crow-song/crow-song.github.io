package com.itheima.web;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductListServlet", urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ProductService service = new ProductService();
//        List<Product> productList=null;
        //模拟当前是第一页
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示12条
        int currentCount =12;
        PageBean<Product> pageBean = null;
        try {
//            productList = service.findAllProduct();
            pageBean = service.findPageBean(currentPage,currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.setAttribute("productList",productList);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher(request.getContextPath()+"product_list.jsp").forward(request,response);
    }
}