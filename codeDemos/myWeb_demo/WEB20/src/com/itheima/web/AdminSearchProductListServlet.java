
package com.itheima.web;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;
import com.itheima.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminSearchProductListServlet", urlPatterns = "/adminSearchProductList")
public class AdminSearchProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //收集表单数据
        Map<String, String[]> properties = request.getParameterMap();
        //将散装数据封装到一个 vo 中
        Condition condition = new Condition();
        try {
            BeanUtils.populate(condition,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //将实体传递给 service
        AdminProductService service = new AdminProductService();
        List<Product> productList=null;
        try {
            productList = service.findProductListByCondition(condition);
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

        //将查询条件一起返回给页面以便页面进行数据回显
        request.setAttribute("condition",condition);

        //将ProductList 放到 request 域
        request.setAttribute("productList",productList);

        request.setAttribute("productList",productList);
        request.getRequestDispatcher(request.getContextPath()+"/admin/product/list.jsp").forward(request,response);
    }
}