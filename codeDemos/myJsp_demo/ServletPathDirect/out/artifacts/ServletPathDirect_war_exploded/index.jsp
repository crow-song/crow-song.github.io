<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h1>Serlvet路径跳转</h1>
  <hr>
  <a href="/servlet/HelloServlet">访问HelloServlet</a><br/>

 <%--request.getContextPath() 表示获得项目的根目录--%>
  <a href="<%=request.getContextPath()%>/servlet/HelloServlet">绝对路径访问HelloServlet<a/><br>
  <a href="servlet/TestServlet">访问TestServlet，跳转到test.jsp<a/>
  </body>
</html>
