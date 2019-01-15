package com.itheima.domain;

public class OrderItem {
//  `itemid` varchar(32) NOT NULL,
//  `count` int(11) DEFAULT NULL,
//  `subtotal` double DEFAULT NULL,
//  `pid` varchar(32) DEFAULT NULL,
//  `oid` varchar(32) DEFAULT NULL,

  private String itemid;//订单项的 id
  private int count;//订单项的商品购买个数
  private double subtotal;//订单项的小计
//  private String pid;//订单项的 pid
  private Product product;//订单项内部的商品（外部的属性用对象表示）
//  private String oid;//订单项的
  private Order order;//该订单项属于哪个订单

  public String getItemid() {
    return itemid;
  }

  public void setItemid(String itemid) {
    this.itemid = itemid;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}

