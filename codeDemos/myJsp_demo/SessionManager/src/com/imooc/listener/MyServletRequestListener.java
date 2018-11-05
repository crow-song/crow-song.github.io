package com.imooc.listener;

import com.imooc.entity.User;
//必须导入 SessionUtil 包，不然无法用 SessionUtil.getUserBySessionId 调用函数
//或者直接用绝对路径表示 com.imooc.util.SessionUtil.getUserBySessionId(userList,sessionIdString)
import com.imooc.util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//配置监听器
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    private ArrayList<User> userList;//在线用户 List
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //userList 不是通过属性得到的，而是从上下文对象得到的
        userList = (ArrayList<User>) servletRequestEvent.getServletContext().getAttribute("userList");
        //如果第一次访问则创建一个 ArrayList
        if(userList==null){
            userList = new ArrayList<User>();
        }
        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();
        String sessionIdString = request.getSession().getId();

        if(SessionUtil.getUserBySessionId(userList,sessionIdString)==null){
            User user = new User();
            user.setSessionIdString(sessionIdString);
            //获取 客户端地址 Ip
            user.setIpString(request.getRemoteAddr());
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            userList.add(user);
        }
        servletRequestEvent.getServletContext().setAttribute("userList",userList);
    }
}
