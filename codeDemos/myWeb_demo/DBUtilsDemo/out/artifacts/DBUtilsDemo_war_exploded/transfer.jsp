<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/12/22
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Transfer</title>
</head>
<body>
<form action="/Transfer" method="post">
  转出人：<input type="text" name="transfer"/><br/>
  转入人：<input type="text" name="transfered"/><br/>
  输入金额：<input type="text" name="money"/><br/>
  <input type="submit" value="确认转账"/><br/>
</form>

</body>
</html>
