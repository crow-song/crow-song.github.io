<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/5
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("requestName","requestValue");
    request.getSession().setAttribute("sessionName","sessionValue");
    request.getSession().getServletContext().setAttribute("contextName","contextValue");

    request.getSession().setAttribute("currentUser", new com.imooc.entity.User());
%>
<html>
<head>
    <title>init</title>
</head>
<body>
初始化值的界面<br/>
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>
