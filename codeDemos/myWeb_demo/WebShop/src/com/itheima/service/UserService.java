package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

public class UserService {
    public boolean register(User user) {

        UserDao dao = new UserDao();
        int flag = 0;
        try {
            flag = dao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag>0?true:false;
    }

    public void active(String activeCode) {
        UserDao dao = new UserDao();
        try {
            dao.active(activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUsername(String username) {

        UserDao dao = new UserDao();
        Long isExist = null;
        try {
            isExist = dao.checkUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isExist>0?false:true;
    }

    public User login(String username, String password) throws SQLException {

        UserDao dao = new UserDao();
        return dao.login(username,password);

    }
}
