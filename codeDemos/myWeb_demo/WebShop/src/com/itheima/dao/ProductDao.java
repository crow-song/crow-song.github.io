package com.itheima.dao;

import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductDao {
    //获得热门商品
    public List<Product> findHotProductList() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot=? limit ?,?";
        return runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);


    }

    //获得最新商品
    public List<Product> findNewProductList() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product order by pdate desc limit ?,?";
        return runner.query(sql,new BeanListHandler<Product>(Product.class),0,9);


    }

    public List<Category> finAllCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category";
        return runner.query(sql,new BeanListHandler<Category>(Category.class));
    }

    public int getCount(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product where cid=?";
        Long count = (Long)runner.query(sql,new ScalarHandler(),cid);
        return count.intValue();
    }

    public List<Product> findProductByPage(String cid, int index, int currentCount) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select * from product where cid=? limit ?,?";
        List<Product> list = runner.query(sql,new BeanListHandler<Product>(Product.class),cid,index,currentCount);
        return list;
    }

    public Product findProductByPid(String pid) throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select * from product where pid=?";
        return runner.query(sql,new BeanHandler<Product>(Product.class),pid);

    }

    //向 Orders 表放数据
    public void addOrders(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql ="insert into orders values(?,?,?,?,?,?,?,?)";
        Connection connection = DataSourceUtils.getConnection();
        runner.update(connection,sql,order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
                order.getAddr(),order.getName(),order.getTelphone(),order.getUser().getUid());
    }

//    向 OrderItems 传数据
    public void addOrderItem(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql ="insert into orderItem values(?,?,?,?,?)";
        Connection connection = DataSourceUtils.getConnection();
        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem:orderItems) {
            runner.update(connection, sql, orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
                    orderItem.getProduct().getPid(),orderItem.getOrder().getOid());

        }
    }

    public void updateOrderAddr(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update orders set address=?,name=?,telephone=? where oid=?";
        runner.update(sql,order.getAddr(),order.getName(),order.getTelphone(),order.getOid());

    }

    public List<Order> findAllOrders(String uid) throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders where uid=?";
        return runner.query(sql,new BeanListHandler<Order>(Order.class),uid);
    }

    public List<Map<String, Object>> fincAllOrderItemByOid(String oid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select i.count,i.subtotal,p.pname,p.pimage,p.shop_price from orderItem i,product p where i.pid=p.pid and i.oid=?";
        List<Map<String,Object>> mapList = runner.query(sql,new MapListHandler(),oid);
        return mapList;


    }
}
