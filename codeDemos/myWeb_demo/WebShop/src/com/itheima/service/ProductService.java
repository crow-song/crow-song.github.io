package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.*;
import com.itheima.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductService {

    public List<Product> findHotProductList() {

        ProductDao dao = new ProductDao();

        List<Product> hotProductList = null;
        try {
            hotProductList = dao.findHotProductList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotProductList;
    }

    public List<Product> findNewProductList() {
        ProductDao dao = new ProductDao();

        List<Product> newProductList = null;
        try {
            newProductList =  dao.findNewProductList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newProductList;
    }

    public List<Category> findAllCategory() {
        ProductDao dao = new ProductDao();
        List<Category> categoryList = null;
        try {
            categoryList = dao.finAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public PageBean findProductByCid(String cid,int currentPage,int currentCount) {

        ProductDao dao = new ProductDao();

        //封装一个 PageBean 返回 web 层
        PageBean<Product> pageBean = new PageBean<Product>();



        //封装当前页
        pageBean.setCurrentPage(currentPage);
        //封装每页显示的条数
        pageBean.setCurrentCount(currentCount);
        //封装总条数/select count(*) from product
        int totalCount = 0;
        try {
            totalCount = dao.getCount(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setTotalCount(totalCount);

        //封装总页数 总条数/每页显示数
        int totalPage = (int)Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);

        //当前页显示的数据 index=(currentPage-1)*currentCount
        //cid 用来表示查询的分类
        //limit 限制的是 where 分类前的索引
        int index = (currentPage-1)*currentCount;
        List<Product> list = null;
        try {
            list = dao.findProductByPage(cid,index,currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setList(list);


        return pageBean;
    }

    public Product findProductByPid(String pid) {
        ProductDao dao = new ProductDao();
        Product product = null;
        try {
            product = dao.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

//    提交订单，将订单和订单项数据存到到数据库
    public void submitOrder(Order order) {
        ProductDao dao = new ProductDao();
        //开启事务
        try {
            DataSourceUtils.startTransaction();
            //调用 dao 存储 order 数据的方法
            dao.addOrders(order);
            //调用 dao 存储 orderItems 的方法
            dao.addOrderItem(order);
        } catch (SQLException e) {
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateOrderAddr(Order order) {
        ProductDao dao = new ProductDao();
        try {
            dao.updateOrderAddr(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获得该用户的订单集合
    public List<Order> findAllOrders(String uid) {
        ProductDao dao = new ProductDao();
        List<Order>orderList = null;
        try {
            orderList = dao.findAllOrders(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Map<String, Object>> findAllOrderItemByOid(String oid) {

        ProductDao dao = new ProductDao();
        List<Map<String, Object>> mapList = null;
        try {
            mapList = dao.fincAllOrderItemByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;

    }
}
