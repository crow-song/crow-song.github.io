package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
//  `oid` varchar(32) NOT NULL,
//  `ordertime` datetime DEFAULT NULL,
//  `total` double DEFAULT NULL,
//  `state` int(11) DEFAULT NULL,
//  `address` varchar(30) DEFAULT NULL,
//  `name` varchar(20) DEFAULT NULL,
//  `telephone` varchar(20) DEFAULT NULL,
//  `uid` varchar(32) DEFAULT NULL,

    private String oid;//该订单的订单号
    private Date ordertime;//下单时间
    private double total;//订单总价格
    private int state;//订单状态（已付款1，未付款0...）

    private String addr;//收货地址
    private String name;//收货人
    private String telphone;//收获人的手机号

    private User user;//订单属于哪个用户

    List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
