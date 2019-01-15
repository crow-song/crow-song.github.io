<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2019/1/8
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>default</title>
</head>
<body>
<%
  //默认访问页面,重定向到 servlet 进行数据库商品读取并显示到主页
  response.sendRedirect(request.getContextPath()+"/product?method=index");
%>

</body>
</html>
