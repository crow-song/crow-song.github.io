<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>forward动作</h1>
    <%--<jsp:forward page="User.jsp" />--%>
    <%
        request.getRequestDispatcher("User.jsp").forward(request,response);
    %>
</body>
</html>
