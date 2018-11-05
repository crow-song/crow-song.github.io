<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="myUsers" class="com.po.Users" scope="page"/>
  <h1>以useBean方式创建javabean实例</h1>
  用户名：<%=myUsers.getUsername()%>
  密码：<%=myUsers.getPassword()%>
  </body>
</html>
