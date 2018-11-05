<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/5
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.removeAttribute("requestName");
    request.getSession().removeAttribute("sessionName");
    request.getSession().getServletContext().removeAttribute("contextName");

    request.getSession().removeAttribute("currentUser");
%>
<html>
<head>
    <title>destory</title>
</head>
<body>
销毁界面
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>
