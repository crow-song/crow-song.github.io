<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dologin</title>
</head>
<body>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="page"/>
    <h1>使用useBean动作创建javaBean实例</h1>
    <hr>
    <!-- 根据表单自动匹配 -->
    <%--<jsp:setProperty name="myUsers" property="*" />--%>
    <!-- 根据表单匹配部分-->
    <%--<jsp:setProperty name="myUsers" property="username" />--%>
    <!-- 跟表单无关，通过手动赋值-->
    <%--<jsp:setProperty name="myUsers" property="password" value="8888888" />--%>
    <!-- 通过url传参数给属性赋值-->
    <jsp:setProperty name="myUsers" property="username" />
    <jsp:setProperty name="myUsers" property="password" param="mypass" />
    <%--用户名：<%=myUsers.getUsername()%>--%>
    <%--密码：<%=myUsers.getPassword()%>--%>
    <jsp:getProperty name="myUsers" property="username" />
    <jsp:getProperty name="myUsers" property="password" />

    <a href="testScope.jsp">测试javabean四个作用域范围</a>
    <%
        request.getRequestDispatcher("testScope.jsp").forward(request,response);
    %>
</body>
</html>
