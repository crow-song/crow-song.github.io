package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    public static void PrintClassMessage(Object obj) {

        Class c = obj.getClass();
        Method[] ms = c.getMethods();

        for(int i = 0; i < ms.length; i++){
            //得到方法返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName()+"");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型，得到的是参数列表的类型的类类型
            Class [] paramTypes = ms[i].getParameterTypes();
            for(Class class1:paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");



        }
    }
    
    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        //成员变量也是对象；
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    //打印对象的构造函数信息
    public static void printConMessage(Object obj){
        Class c = obj.getClass();
        /*构造函数也是对象
        java.lang.Constructor 封装了构造函数的信息
        getConstructors 获取所有的 public 的构造函数
        Constructor []cs = c.getConstructors();
        */
        Constructor [] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName()+"(");
            //获取构造函数的参数列表-->得到的是参数列表的类类型
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class class1 : parameterTypes) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");

        }

    }
}
