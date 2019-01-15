package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Product> findAllProduct() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product";
        List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
        return productList;
    }

    public int getTotalCount() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select count(*) from product";
        Long query = (Long)runner.query(sql, new ScalarHandler());
        return query.intValue();
    }
    //获得分页的商品数据
    public List<Product> findProductListForPageBean(int index,int currentCount) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product limit ?,?";
        return runner.query(sql,new BeanListHandler<Product>(Product.class),index,currentCount);


    }

    public List<Object> findProductByWord(String keyword) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pname like ? limit 0,8";
        List<Object> query = runner.query(sql,new ColumnListHandler("pname"),"%"+keyword+"%");
        return query;
    }
}
