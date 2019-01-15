package com.itheima.service;

import com.itheima.dao.TransferDao;
import com.itheima.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferService {


    public boolean transferMoney(double money,String outName,String inName){
        TransferDao dao = new TransferDao();
        boolean isTransferSuccess = true;
        Connection conn = null;
        try {

//            conn = DataSourceUtils.getConnection();
//            conn.setAutoCommit(false);
            DataSourceUtils.startTransaction();

            dao.transferMoney(money,outName);
            int i = 1/0;
            dao.transferedMoney(money,inName);

        } catch (Exception e) {
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            isTransferSuccess = false;
            e.printStackTrace();
        }finally{
            try {
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isTransferSuccess;


    }



}
