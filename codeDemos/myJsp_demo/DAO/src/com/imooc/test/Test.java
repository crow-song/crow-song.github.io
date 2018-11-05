package com.imooc.test;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);//查询 id 为 10 的用户

        Filter f2 = new Filter();
        f2.setUserName("lucy");//查询用户名为 lucy 的用户

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");//查询邮箱为其中任意一个用户

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }


    private static String query(Filter f){
        StringBuilder sb = new StringBuilder();

        //获取 class
        Class c = f.getClass();

        //获取 table 的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if(!exists){
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        /**
         *  例如为不定数量的查询条件，我们在后台写查询的时候，
         类似于这样的语句 string sql ="select * from table where"
         为了使语句通顺不报错，加上 where 1=1
         */
        sb.append("select * form").append(tableName).append("where 1=1");

        //遍历所有的字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            //处理每个字段对应的 sql
            //拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if(!fExists){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            //拿到字段值
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            //通过反射取得 method
            System.out.println(getMethodName);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //拼装 sql
            if(fieldValue==null ||(fieldValue instanceof Integer && (Integer)fieldValue==0)){
                continue;
            }
            sb.append(" and ").append(filedName);
            if(fieldValue instanceof String){
                sb.append("=").append("'").append(columnName).append("'");
            }else if(fieldValue instanceof Integer) {
                sb.append("=").append(columnName);
            }
        }
        return sb.toString();
    }
}
