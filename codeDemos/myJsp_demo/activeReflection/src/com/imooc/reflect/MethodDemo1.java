package com.imooc.reflect;

import java.lang.reflect.Method;

public class MethodDemo1 {
    public static void main(String[] args) {
        //获取print(int a,int b)方法，获取一个方法就是获取类的信息，获取类的信息就要获得类的类类型
        A a1 = new A();
        Class c = a1.getClass();

        /**
         * 获取方法 名称和参数决定
         * getMethod 获取的是 public 的方法
         * getDelcaredMethod 自己声明的方法
         */
        try {
            Method m = c.getMethod("print", int.class, int.class);
//          或 Method m = c.getMethod("pirnt", new Class[]{int.class, int.class});
            /**
             * 方法的反射操作
             * a1.print(10,20); 方法的反射操作是用 m 对象来进行方法的调用 和 a1.print 调用效果完全相同
             * 方法没有返回值，则返回 null ，有返回值则返回具体的返回值
             */

            Object o = m.invoke(a1, new Object[]{10, 20});

            System.out.println("===========");
            //获取方法对象
            Method m1 = c.getMethod("print", String.class, String.class);
            //用方法进行反射操作
            o = m1.invoke(a1, "Hello", "Word");

            System.out.println("===========");
            Method m2 = c.getMethod("print");
            //或 Method m1 = c.getMethod("print", new Class[]{});
            m2.invoke(a1);
            //  或m2.invoke(a1,new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
    public void print(){
        System.out.println("hello Word");
    }
}