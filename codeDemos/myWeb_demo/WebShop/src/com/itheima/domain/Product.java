package com.itheima.domain;

import java.util.Date;

public class Product {
//  `pid` varchar(32) NOT NULL,
//  `pname` varchar(50) DEFAULT NULL,
//  `market_price` double DEFAULT NULL,
//            `shop_price` double DEFAULT NULL,
//            `pimage` varchar(200) DEFAULT NULL,
//  `pdate` date DEFAULT NULL,
//            `is_hot` int(11) DEFAULT NULL,
//  `pdesc` varchar(255) DEFAULT NULL,
//  `pflag` int(11) DEFAULT NULL,
//  `cid` varchar(32) DEFAULT NULL,

    private String pid;
    private String pname;
    private Double market_price;
    private Double shop_price;
    private String pimage;
    private Date   pdate;
    private int    is_hot;
    private String pdesc;
    private int    pflag;
    //java 是面向对象语言，可以用引入对象来表示类型代替 cid
//    private String cid;
    private Category category;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
