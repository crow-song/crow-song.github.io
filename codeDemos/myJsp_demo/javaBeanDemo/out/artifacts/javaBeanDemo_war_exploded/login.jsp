<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h1>系统登录</h1>
    <hr>
    <form name="loginForm" action="dologin.jsp?mypass= 999999" method="post">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"></td>

        </tr>
    </form>
</body>
</html>
