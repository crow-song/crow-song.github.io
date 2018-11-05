package com.imooc.dao;

import com.imooc.bean.Command;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 与指令表对应的数据库操作
 */
public class CommandDao {
    /**
     * 根据查询条件查询指令列表
     */
    public List<Command> queryCommandList(String name, String description){
        DBAccess dbAccess = new DBAccess();
        //要在 final 中关闭此会话，所以放在外面
        SqlSession sqlSession = null;
        //创建 List 将查询语句内容放进 List 中
        List<Command>commandList = new ArrayList<Command>();
        //捕获 DBAccess 抛出的异常
        try {
            sqlSession = dbAccess.getSqlSession();
            //新建一个对象，将 command description 对象封装到对象中
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);

            //通过 sqlSession 执行 查找sql 语句；值为 namespace.sqlId(为 select delete... 的 id 值)
            commandList = sqlSession.selectList("Command.queryCommandList",command);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();

            }
        }
        return commandList;

    }
}
