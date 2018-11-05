package com.imooc.listener;

import com.imooc.entity.User;
import com.imooc.util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private int userNumber = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);

        ArrayList<User> userList = null;//在线用户 List

//为了获取 userList 在 MyServletRequestListener.java 中通过 SetAttribute 把 userList 放到上下文对象中
//        servletRequestEvent.getServletContext().setAttribute("userList",userList);

        userList = (ArrayList<User>) httpSessionEvent.getSession().getServletContext().getAttribute("userList");
        //判断是否存在
        if(SessionUtil.getUserBySessionId(userList, httpSessionEvent.getSession().getId())!=null) {
            userList.remove(SessionUtil.getUserBySessionId(userList, httpSessionEvent.getSession().getId()));
        }
    }
}
