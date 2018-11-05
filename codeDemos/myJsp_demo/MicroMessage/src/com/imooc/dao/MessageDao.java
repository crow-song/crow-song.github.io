package com.imooc.dao;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Dao 层跟表相关，此 dao 包含跟 message 表相关的操作
public class MessageDao {

    /**
     * mybytis 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(String command,String description){
        DBAccess dbAccess = new DBAccess();
        //要在 final 中关闭此会话，所以放在外面
        SqlSession sqlSession = null;
        //创建 List 将查询语句内容放进 List 中
        List<Message>messageList = new ArrayList<Message>();
        //捕获 DBAccess 抛出的异常
        try {
            sqlSession = dbAccess.getSqlSession();
            //新建一个对象，将 command description 对象封装到对象中
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);

            //通过 sqlSession 执行 查找sql 语句；值为 namespace.resultMap
            messageList = sqlSession.selectList("Message.queryMessageList",message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();

            }
        }
        return messageList;

    }

    /**
     *
     * 单条删除
     */
    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        //要在 final 中关闭此会话，所以放在外面
        SqlSession sqlSession = null;
        //捕获 DBAccess 抛出的异常
        try {
            sqlSession = dbAccess.getSqlSession();
            //通过 sqlSession 执行 删除sql 语句；值为 Message.mapper 的 namespace.resultMap
            sqlSession.delete("Message.deleteOne",id);
            //使用 mybatis 时对 commit 进行了封装，需要手动进行提交
            /**
             * Connection conn;
             * 下面两条sql语句是自动提交互不影响的
             * 但是将 conn.setAutoCommit(false) 设定后，下面的 sql 语句将处于一个事物中
             * 需要进行 conn.commit(); 或 conn.roolback(); 才能一次性手动提交
             * conn.prepareStatement("sql").execute();
             * conn.prepareStetement("sql").execute();
             * conn.commit();
             *
             *
             * 如下的 sqlSession.commit()；实际上就是 conn.commmit();
             */
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }


    /**
     * 批量删除
     */

    public void deleteBatch(List<Integer> ids){
        DBAccess dbaccess = new DBAccess();
        SqlSession sqlsession = null;
        try {
            sqlsession = dbaccess.getSqlSession();
            //执行删除语句
            sqlsession.delete("Message.deleteBatch",ids);
            sqlsession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//
//    public static void main(String[] args) {
//        MessageDao messageDao = new MessageDao();
//        messageDao.queryMessageList("","");
//
//    }
    /**
     * 根据查询条件查询消息列表
     */
//    public List<Message> queryMessageList(String command,String description){
//        List<Message>messageList = new ArrayList<Message>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message",
//                    "root","dfwhj43815");
//            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//            //创建一个 List 将需要拼接的 sql 语句查询内容装进去，最后用 for 循环取出，set 到 PreparedStatement 后执行
//            List<String> paramList = new ArrayList<String>();
//            //.trim() 方法返回一个 String 的副本，用来去除首尾的空格
//            if(command != null && !"".equals(command.trim())){
//                //查询sql语句拼接不用sql.append(" and command = '"+command+"'")  因为容易被SQL注入攻击
//                sql.append(" and COMMAND=?");
//                paramList.add(command);
//            }
//            if(description != null && !"".equals(description.trim())){
//                sql.append(" and DESCRIPTION like '%' ? '%'");
//                paramList.add(description);
//            }
//            PreparedStatement ps = conn.prepareStatement(sql.toString());
//            //在 sql 语句执行前，将参数加进去
//            for (int i = 0; i < paramList.size(); i++) {
//                ps.setString(i + 1,paramList.get(i));
//            }
//            ResultSet rs = ps.executeQuery();
//
//
//            while(rs.next()){
//                Message message = new Message();
//                //添加到容器中的不是对象本身，此时操作对象仍可以改变在容器中的内容。
//                //也可以将对象在最后添加到容器
//                message.setId(rs.getString("ID"));
//                message.setCommand(rs.getString("COMMAND"));
//                message.setDescription(rs.getString("DESCRIPTION"));
//                message.setContent(rs.getString("CONTENT"));
//                messageList.add(message);
//
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return messageList;
//    }
}
