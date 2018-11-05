<%@ page import="com.po.Users" %><%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testScope</title>
</head>
<body>
    <h1>javaBean的四个作用域范围</h1>
    <hr>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="page" />
    用户名：<jsp:getProperty name="myUsers" property="username" />
    密码：<jsp:getProperty name="myUsers" property="password" />
    <!-- 使用内置对象获取用户名和密码-->
    <hr>
    <%--用户名：<%=((Users)application.getAttribute("myUsers")).getUsername()%>--%>
    <%--密码：<%=((Users)application.getAttribute("myUsers")).getPassword()%>--%>


    <%--用户名：<%=((Users)session.getAttribute("myUsers")).getUsername()%>--%>
    <%--密码：<%=((Users)session.getAttribute("myUsers")).getPassword()%>--%>

    <%--用户名：<%=((Users)request.getAttribute("myUsers")).getUsername()%>--%>
    <%--密码：<%=((Users)request.getAttribute("myUsers")).getPassword()%> --%>

    <%
        String username = "";
        String password = "";
        if(pageContext.getAttribute("myUsers")!=null){
            username = ((Users)pageContext.getAttribute("myUsers")).getUsername();
            password = ((Users)pageContext.getAttribute("myUsers")).getPassword();

        }
    %>

    用户名：<%=username%>
    密码：<%=password%>

</body>
</html>
