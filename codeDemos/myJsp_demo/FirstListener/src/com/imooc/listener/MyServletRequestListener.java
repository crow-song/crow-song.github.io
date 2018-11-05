package com.imooc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        从浏览器地址栏输入 ?name=lalala 可以获取 name 的值 lalala
        String name = servletRequestEvent.getServletRequest().getParameter("name");
        System.out.println("requestInitialized name:" + name);
    }
}
