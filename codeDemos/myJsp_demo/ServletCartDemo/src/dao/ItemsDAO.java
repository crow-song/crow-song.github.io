package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//商品业务逻辑类
public class ItemsDAO {

    //获得所有商品信息
    public ArrayList<Items> getAllItems(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Items> list = new ArrayList<Items>();//商品集合

        try{
            conn = DBHelper.getConnection();
            String sql = "select * from Items";//SQL语句
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setPrice(rs.getInt("price"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));
                list.add(item);//遍历并把商品加入集合
            }
            return list;//返回集合；
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally{
            //释放数据集对象
            if(rs!=null){
                try {
                    rs.close();

                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if(stmt!=null){
                try {
                    stmt.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }


    public  Items getItemsById(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try{
            conn = DBHelper.getConnection();
            String sql = "select * from Items where id=?";//SQL语句
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);//在第 1 个问号，填入id
            rs = stmt.executeQuery();

            if(rs.next()){
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setPrice(rs.getInt("price"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));
                return item;
            }
            else{
                return null;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally{
            //释放数据集对象
            if(rs!=null){
                try {
                    rs.close();

                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if(stmt!=null){
                try {
                    stmt.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Items> getViewList(String list){
        int iCount = 5;//返回iCount条记录
        ArrayList<Items> itemlist = new ArrayList<Items>();
        if(list!=null && list.length()>0){
            String [] arr = list.split("#");
            //如果商品记录大于等于iCount则取最后iCount条
            if(arr.length>5){
                for(int i=arr.length-1; i>arr.length-iCount; i--){
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            else{
                for(int i=arr.length-1; i>=0; i--){
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemlist;
        }
        else{
            return null;
        }
    }
}

