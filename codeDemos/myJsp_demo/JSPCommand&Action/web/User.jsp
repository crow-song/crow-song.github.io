<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/14
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
    <h1>用户资料</h1>
    <hr>
    <%
        request.setCharacterEncoding("utf-8");
        String username = null;
        String password = null;
        String email = null;
        if(request.getParameter("username")!=null){
            username = request.getParameter("username");
        }
        if(request.getParameter("password")!=null){
            password = request.getParameter("password");
        }
        if(request.getParameter("email")!=null){
            email = request.getParameter("email");
        }
    %>
    用户名：<%=username%><br>
    密码：<%=password%><br>
    邮箱：<%=email%><br>
</body>
</html>
