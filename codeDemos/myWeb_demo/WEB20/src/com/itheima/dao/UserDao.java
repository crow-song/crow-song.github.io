package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
        public Long checkUserName(String username) throws SQLException {
            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            String sql = "select count(*) from user where username=?";
            Long query = (Long)runner.query(sql,new ScalarHandler(),username);
            return query;
    }

    public User login(String username, String password) throws SQLException {

            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            String sql = "select * from user where username=? and password=?";
            return runner.query(sql,new BeanHandler<User>(User.class),username,password);
    }

    public void regist(User user) throws SQLException {

            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            String sql = "insert into user value(?,?,?,?,?,?,?,?,?,?)";
            runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                    user.getName(),user.getEmail(),null,user.getBirthday(),user.getSex(),null,null);

    }
}
