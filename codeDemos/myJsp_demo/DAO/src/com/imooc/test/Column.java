package com.imooc.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//作用域：字段、枚举的常量
@Target({ElementType.FIELD})
//生命周期：运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String value();
}
