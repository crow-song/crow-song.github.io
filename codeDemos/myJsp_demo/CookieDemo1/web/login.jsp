
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/13
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h1>用户登录</h1>
    <hr>
    <%
        request.setCharacterEncoding("utf-8");
        String username="";
        String password="";
        Cookie[] cookies =request.getCookies();
        if(cookies!=null && cookies.length>0){
            for(Cookie c : cookies){
                if(c.getName().equals("username")){
//                    username = c.getValue();
                    username = URLDecoder.decode(c.getValue(),"utf-8");
                }
                if(c.getName().equals("password")){
//                    password = c.getValue();
                    password = URLDecoder.decode(c.getValue(),"utf-8");
                }
            }
        }
    %>

    <form name="loginForm" action="dologin.jsp" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" value="<%=username%>" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" value="<%=password%>"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked" />十天内记住我</td>

            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="submit1" value="请登录"/><input type="reset" name="reset1" value="取消"></td>
                <td></td>
            </tr>
        </table>
    </form>
</body>
</html>
