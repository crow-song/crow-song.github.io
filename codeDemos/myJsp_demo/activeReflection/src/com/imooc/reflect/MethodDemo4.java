package com.imooc.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        //泛型，只能放 String 类型；
        //防止加入 list1.add(10); 这种操作
        ArrayList<String>list1 = new ArrayList<>();
        list1.add("hello");
        Class c1 = list.getClass();
        Class c2 = list1.getClass();

        System.out.println(c1 == c2);
        /**
         * 反射的操作都是编译之后的操作（跳过编译阶段）
         * c1 == c2 返回 true 说明编译之后的集合泛型是去泛型化的
         * java 中集合的泛型是防止错误输入，只在编译阶段有效，绕过编译就无效
         * 验证：通过方法反射操作，绕过编译
         */

        Method m = null;
        try {
            m = c2.getMethod("add", Object.class);
            m.invoke(list1,10);//绕过编译操作就绕过了泛型
            System.out.println(list1.size());

            /**
             *  for (String string : list1) {
                    System.out.println(string);
                }
                此时遍历会发生错误异常，提示不能将 int 转换成 String
             * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
             */


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
