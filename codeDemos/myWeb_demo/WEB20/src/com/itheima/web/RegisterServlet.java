package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request.setCharacterEncoding("UTF-8");
        //获取表单数据
        Map<String, String[]> properties = request.getParameterMap();

        String username = request.getParameter("username");


        System.out.println(username);

        //将散装数据封装到 javaBean
        User user = new User();
        try {
            BeanUtils.populate(user,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //因为页面没有 uid ，需要手动添加
        user.setUid(UUID.randomUUID().toString());

        //将参数传递个Service
        UserService service = new UserService();
        try {
            service.regist(user);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}