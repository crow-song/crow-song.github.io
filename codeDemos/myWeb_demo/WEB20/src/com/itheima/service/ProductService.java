package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.vo.PageBean;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAllProduct() throws SQLException {
        ProductDao dao = new ProductDao();
        List<Product> productList = dao.findAllProduct();
        return productList;
    }
    //分页操作
    public PageBean findPageBean(int currentPage, int currentCount) throws SQLException {
        ProductDao dao = new ProductDao();

        //创建一个 PageBean 并返回给 web
        PageBean pageBean = new PageBean();
        //当前页数private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount = dao.getTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        //每页显示的数据private List<T> productList = new ArrayList<T>();
        int index = (currentPage-1)*currentCount;
        List<Product> productList = dao.findProductListForPageBean(index,currentCount);
        pageBean.setProductList(productList);

        return pageBean;
    }

    public List<Object> findProductByWord(String keyword) throws SQLException {
        //根据关键字查询商品
        ProductDao dao = new ProductDao();
        return dao.findProductByWord(keyword);
    }
}
