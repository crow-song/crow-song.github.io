package com.ann.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
//只能取到运行时加载
public class PraseAnn {
    public static void main(String[] args) {
        try {
            //使用类加载器加载类
            Class c = Class.forName("com.ann.test.Child");
            //找到类上的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                //拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());

            }

            //找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if(isMExist){
                    Description d =  m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //另一种解析方法
            for (Method m : ms) {
                Annotation[]as = m.getAnnotations();
                for (Annotation a : as) {
                    if(a instanceof Description){
                        Description d = (Description) a;
                        System.out.println(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
