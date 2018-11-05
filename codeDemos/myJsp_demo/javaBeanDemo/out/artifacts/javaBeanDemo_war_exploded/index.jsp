<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.po.Users" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Users user = new Users();
    user.setUsername("admin");
    user.setPassword("123456");
  %>
  <h1>以普通方式创建javabean实例</h1>
  用户名：<%=user.getUsername()%>
  密码：<%=user.getPassword()%>
  </body>
</html>
