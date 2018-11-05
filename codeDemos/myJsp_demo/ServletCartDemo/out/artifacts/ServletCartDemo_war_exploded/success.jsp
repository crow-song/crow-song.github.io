<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/26
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <center>
        <div class="">
            <%--images 前不加 / 无法显示图片--%>
        <a herf="#"><img src="/images/add_cart_success.jpg" /><a/>
        <hr>
        <%
            String id = request.getParameter("id");
            String num = request.getParameter("number");
        %>
        您已成功购买了 <%=num%> 件商品编号为 <%=id%> 的商品&nbsp&nbsp
        <br>
        <br>
        <br>
    </center>
</body>
</html>
