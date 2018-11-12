package com.itheima.springmvc.service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 查询商品信息
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    //查询商品列表
    public List<Items> selectItemsList(){
        return itemsMapper.selectByExampleWithBLOBs(null);
    }
    public Items selectItemsById(Integer id){
        return itemsMapper.selectByPrimaryKey(id);
    }
    //修改
    public void updateItemsById(Items items){
        items.setCreatetime(new Date());
        int i = itemsMapper.updateByPrimaryKeyWithBLOBs(items);
        System.out.println("是否成功：" + i);
    }
}
