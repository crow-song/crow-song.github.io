package com.imooc.test;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//作用域：类或接口
@Target({ElementType.TYPE})
//生命周期：运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    //使用值只有一个：表名 user
    String value();
}
