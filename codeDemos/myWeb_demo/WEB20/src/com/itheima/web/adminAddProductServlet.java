package com.itheima.web;

import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "adminAddProductServlet", urlPatterns = "/adminAddProduct")
public class adminAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单数据
        Map<String, String[]> properties = request.getParameterMap();
        //封装数据
        Product product = new Product();
        try {
            BeanUtils.populate(product,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //表单提交数据封装完璧，还需手动添加 Product 剩余数据
        //1.private String pid;
        product.setPid(UUID.randomUUID().toString());
        //2.private String Pimage;
        product.setPimage("products/1/c_0039.jpg");
        //3.private String pdate;上架日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String pdate = format.format(new Date());
        product.setPdate(pdate);
        //4.private int pflag;商品是否下架0在1下架
        product.setPflag(0);


        //传递数据给 service
        AdminProductService service = new AdminProductService();
        try {
            service.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转到列表页面
        response.sendRedirect(request.getContextPath()+"/adminProductList");
    }
}