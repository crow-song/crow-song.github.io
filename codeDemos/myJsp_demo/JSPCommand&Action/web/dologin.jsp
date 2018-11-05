<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/14
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dologin</title>
</head>
<body>
    <jsp:forward page="User.jsp">
        <jsp:param value="admin@163.com" name="email"/>
        <jsp:param value="666666" name="password" />
    </jsp:forward>
</body>
</html>
