package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获得请求的 method 名称
            String methodName = req.getParameter("method");
            //获得当前被访问对象的 字节码对象
            Class clazz = this.getClass();
            //获得当前字节码对象中的方法，参数为 （方法名，request 的字节码对象，response 的字节码对象）
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
