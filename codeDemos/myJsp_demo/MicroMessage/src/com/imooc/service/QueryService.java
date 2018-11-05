package com.imooc.service;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.bean.Message;
import com.imooc.dao.CommandDao;
import com.imooc.dao.MessageDao;
import com.imooc.util.Iconst;

import java.util.List;
import java.util.Random;

public class QueryService {
    //调用 MessageDao 进行数据操作，再由 ListServlet 调用。将值返回给 ListServlet
    public List<Message> queryMessageList(String command, String description){
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command,description);
    }


    /**
     * 通过指令查询自动回复内容
     */
    public String queryByCommand(String command){
//        MessageDao messageDao = new MessageDao();
        CommandDao commandDao = new CommandDao();
//        List<Message> messageList;
        List<Command> commandList;
        if(Iconst.HELP_COMMAND.equals(command)){
//            如果指令是帮助，则将所有指令查出来并拼接；
//            messageList = messageDao.queryMessageList(null, null);
            commandList = commandDao.queryCommandList(null, null);
            StringBuilder result = new StringBuilder();
//            for(int i= 0;i < messageList.size();i++){
            for(int i= 0;i < commandList.size();i++){
                //如果不是第一行则添加换行
                if(i !=0){
                    result.append("<br/>");
                }
//                拼接所有查询出来的指令及描述
//                result.append("回复[" + messageList.get(i).getCommand() + "]可以查看"
//                        + messageList.get(i).getDescription());
                result.append("回复[" + commandList.get(i).getName() + "]可以查看"
                        + commandList.get(i).getDescription());
            }
            return result.toString();
        }
        //只需要通过指令，不需要描述来查询自动回复,如果为 null 则不进入 if 判断语句，不会添加 and sql 语句
//        messageList = messageDao.queryMessageList(command, null);
//        if(messageList.size() > 0){
//            return messageList.get(0).getContent();
//        }
        commandList = commandDao.queryCommandList(command, null);
        if(commandList.size() > 0){
            //取得第一条查询语句的 子表集合内容/列表信息
            List<CommandContent> contentList = commandList.get(0).getContentList();
            //取得列表信息其中一条返回
            //取 [0,size()) 的随机数
            int i = new Random().nextInt(contentList.size());
//            取得随机的 commandContent 的对象，然后从对象中取得内容
            return contentList.get(i).getContent();
        }
        //当指令没有匹配的回复内容时，用此内容替代
        return Iconst.NO_MATCHING_CONTENT;
    }


}
