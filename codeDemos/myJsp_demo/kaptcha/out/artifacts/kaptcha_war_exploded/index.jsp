<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/11
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="check.jsp">
      <%--是否加 ‘/’ 没区别  加了'/' 表示项目路径开头路径，与 tomcat 配置路径有关--%>
      <img src="/randomcode.jpg">
      <input type="text" name="r"/>
      <input type="submit">

  </form>

  </body>
</html>
