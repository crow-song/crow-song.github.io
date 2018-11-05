package com.dao;
import com.po.Users;
//用户业务逻辑类
public class UsersDAO {
    public boolean userLogin(Users u){
        if("admin".equals(u.getUsername()) && "admin".equals(u.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
}
