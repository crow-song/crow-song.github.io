package com.itheima.service;

import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.Product;

import java.util.List;
import java.util.Map;

public interface AdminService {

    public List<Category> findAllCategory();

    public void saveProduct(Product product);

    public List<Order> findAllOrders();

    public List<Map<String, Object>> findOrderInfoByOid(String oid);
}
