package com.ann.test;
@Description("i am interface")
public interface Person {
    @Description("i am interface method")
    public String name();
    public int age();
    @Deprecated
    public void sing();
}
