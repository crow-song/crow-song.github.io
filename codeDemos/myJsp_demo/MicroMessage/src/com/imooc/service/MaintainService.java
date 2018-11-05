package com.imooc.service;

import com.imooc.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护 Service
 * 维护相关业务的功能
 * 页面的一个动作对应了一个 Servlet ；而 Service 不应该同时增加
 * 把相似的功能（修改，新增，删除，批量删除等）放在一个维护 Service 中
 * 以后可以一直添加新功能
 *
 * 将取值的转型及判断是否为空 都放在 Service 中进行
 */
public class MaintainService {
    /**
     * 单条删除
     */
    public void deleteOne(String id){
        //判断 id 是否为空，或 空字符串
        if(id != null && !"".equals(id.trim())) {
            MessageDao messageDao = new MessageDao();
            //将 id 从 String 转型为 int 并作为参数传入 deleteOne 函数
            messageDao.deleteOne(Integer.valueOf(id));
        }


    }

    /**
     * 批量删除
     */
    public void deleteBatch(String [] ids){
        MessageDao messageDao = new MessageDao();
        //创建 id 的 List
        List<Integer> idList = new ArrayList<Integer>();
        for (String id : ids) {
            //转型为 Integer 再传入 List
            if(id!=null && !"".equals(id.trim())) {
                idList.add(Integer.valueOf(id));
            }
        }
        //调用 messageDao 的 deleteBatch 方法
        messageDao.deleteBatch(idList);
    }
}
