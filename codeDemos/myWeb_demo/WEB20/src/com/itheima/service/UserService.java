package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

public class UserService {
    public boolean checkUserName(String username) throws SQLException{
        UserDao dao = new UserDao();
        Long isExist = dao.checkUserName(username);
        return isExist>0?true:false;
    }

    public User login(String username, String password) throws SQLException {

        UserDao dao = new UserDao();
        return dao.login(username,password);

    }

    public void regist(User user) throws SQLException {
        UserDao dao = new UserDao();
        dao.regist(user);
    }
}
