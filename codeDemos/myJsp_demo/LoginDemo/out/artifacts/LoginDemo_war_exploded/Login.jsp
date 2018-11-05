<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/8
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link type="text/css" href="css/login.css" rel="stylesheet" />
    <link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/easyTooltip.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
    <title>Login</title>
    <%--<script type="text/javascript">--%>
        <%--$(document).ready(function(){--%>
            <%--输出--%>
            <%--$("div").html("lalala");--%>

            <%--输出对象并设置输出对象的css属性--%>
            <%--var $p = $('#one');--%>
            <%--$p.html('任天堂是世界的主宰!').css('color','red');--%>

        <%--});--%>


     <%--</script>--%>

  </head>
  <body>
  <p id="one"></p>
    <div id="container">
      <div class="logo">
        <a href="#"><img src="assets/logo.png" alt="" /></a>
      </div>
      <div id="box">
        <form action="dologin.jsp" method="post">
          <p class="main">
            <label>用户名：</label>
            <input name="username" value="" />
            <label>密码：</label>
            <input type="password" name="password" value="" />
          </p>
          <p class="space">
            <input type="submit" value="登录" class="login" style="cursor: pointer">
          </p>
        </form>
      </div>
    </div>


  <%--<script type="text/javascript">--%>
      <%--用get方法将jquery对象转换成DOM对象--%>
      <%--var $label = $('label');--%>
      <%--var label = $label.get(0);--%>
      <%--label.style.color = 'red';--%>

  <%--</script>--%>
  </body>
</html>
