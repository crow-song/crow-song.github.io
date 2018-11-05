package com.imooc.test;

@Table("user")
public class Filter {
    /**
     Column column = field.getAnnotation(Column.class);得到的是字段上注解内容，然后通过

     String columnName = column.value();得到就是此注解下的字段名，

     @Column("id") （好比上面的 column，不过只是比如column是一个注解对象）
     private int id;  （columnName 就得到的是  id  ）

     @Table("数据库中的表名")
     @Column("数据库中的列名/字段名:id/user_name...")
     */
    @Column("id")
    private int id;

    @Column("user_name")
    private String userName;

    @Column("nick_name")
    private String nickName;

    @Column("age")
    private int age;

    @Column("city")
    private String city;

    @Column("email")
    private String email;

    @Column("mobile")
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
