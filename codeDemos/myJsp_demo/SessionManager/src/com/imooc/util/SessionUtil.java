package com.imooc.util;

import com.imooc.entity.User;

import java.util.ArrayList;

public class SessionUtil {
    //静态函数可以在 MyServletRequestListener.java 中直接 SessionUtil.getUserBySessionId 调用
    //必须为 public 不然无法被其他类所调用
    public static Object getUserBySessionId(ArrayList<User> userList,String sessionIdString){
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if(user.getSessionIdString().equals(sessionIdString)){
                return user;
            }
        }

        return null;
    }
}
