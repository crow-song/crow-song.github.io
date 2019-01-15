package com.itheima.service;

import com.itheima.dao.AdminProductDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.vo.Condition;

import java.sql.SQLException;
import java.util.List;

public class AdminProductService {

    //查询所有商品方法
    public List<Product> findAllProducts() throws SQLException{
        //没有复杂业务，直接传递请求到 DAO 层
        AdminProductDao dao = new AdminProductDao();
        return dao.findAllProducts();
    }
    //获得所有的类别
    public List<Category> findAllCategory() throws SQLException{
        AdminProductDao dao = new AdminProductDao();
        return dao.finAllCategory();
    }
    //添加商品
    public void addProduct(Product product) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.addProduct(product);
    }

    public void delProduct(String pid) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.delProduct(pid);
    }

    public Product findProductById(String pid) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.findProductById(pid);
    }

    public void updateProduct(Product product) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.updateProduct(product);
    }

    //根据条件查询商品
    public List<Product> findProductListByCondition(Condition condition) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.findProductListByCondition(condition);

    }

    public void delProductListByIds(String userIdList) {

    }
}
