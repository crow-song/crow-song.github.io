<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/3
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%=request.getSession().getAttribute("currentUser")%>
  my listener
  <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
  <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
  </body>
</html>
