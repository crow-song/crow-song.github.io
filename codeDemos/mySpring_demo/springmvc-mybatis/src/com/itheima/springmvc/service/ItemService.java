package com.itheima.springmvc.service;

import com.itheima.springmvc.pojo.Items;

import java.util.List;

public interface ItemService {
    //查询商品列表
    public List<Items> selectItemsList();

    //查询一个商品
    public Items selectItemsById(Integer id);

    //修改
    public void updateItemsById(Items items);
}
