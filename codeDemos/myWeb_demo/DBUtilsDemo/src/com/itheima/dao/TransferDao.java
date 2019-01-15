package com.itheima.dao;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferDao {


    public void transferMoney(double money, String outName) throws SQLException {
//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        QueryRunner runner = new QueryRunner();
        Connection conn = DataSourceUtils.getCurrentConnection();
        String sql = "update account set money=money-? where name=?";
        runner.update(conn,sql,money,outName);

    }

    public void transferedMoney(double money, String inName) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Connection conn = DataSourceUtils.getCurrentConnection();
        String sql = "update account set money=money+? where name=?";
        runner.update(conn,sql,money,inName);

    }
}
