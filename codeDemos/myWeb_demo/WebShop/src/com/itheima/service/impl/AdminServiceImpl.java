package com.itheima.service.impl;

import com.itheima.dao.AdminDao;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.AdminService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    public List<Category> findAllCategory() {
        AdminDao dao = new AdminDao();
        List<Category> categoryList = null;
        try {
            categoryList = dao.finAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public void saveProduct(Product product) {
        AdminDao dao = new AdminDao();
        try {
            dao.saveProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAllOrders() {
        AdminDao dao = new AdminDao();
        List<Order> orderList = null;
        try {
            orderList = dao.findAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Map<String, Object>> findOrderInfoByOid(String oid) {
        AdminDao dao = new AdminDao();
        List<Map<String, Object>>  orderList = null;
        try {
            orderList = dao.findOrderInfoByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
