package com.ann.test;

import java.lang.annotation.*;
import java.util.Map;
//自定义注解，在 Child 中使用
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String  value();


}
