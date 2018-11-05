<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/21
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>MyFirst Servlet</title>
  </head>
  <body>
  <h1>Servlet小例子</h1>
  <hr>
  <a href="servlet/HelloServlet">Get方式请求HelloServlet</a>
  <form action="servlet/HelloServlet" method="post">
    <input type="submit" value="Post方式请求HelloServlet";/>
  </form>
  </body>
</html>
