<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my reg jsp start page</title>
    <style>
        .label{
            width: 20%;
        }
        .controller{
            width: 80%;
        }
    </style>
</head>
<script type="text/javascript" src="js/Calendar3.js"></script>
<body>
    <h1>用户注册</h1>
    <hr>
    <form name="regForm" action="servlet/RegServlet" method="post">
        <table border="0" width="800" cellspacing="0" cellpadding="0">
            <tr>
                <td class="label">用户名：</td>
                <td class="controller"><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td class="label">密码：</td>
                <td class="controller"><input type="password" name="mypassword"/></td>
            </tr>
            <tr>
                <td class="label">确认密码：</td>
                <td class="controller"><input type="password" name="confirmpass"/></td>
            </tr>
            <tr>
                <td class="label">电子邮箱：</td>
                <td class="controller"><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td class="label">性别：</td>
                <td class="controller">
                    <input type="radio" name="gender" checked="checked" value="Male"/>男
                    <input type="radio" name="gender" value="Female"/>女
                </td>
            </tr>
            <tr>
                <td class="label">出生日期：</td>
                <td class="controller">
                    <input name="birthday" type="text" id="control_date" size="10"
                           maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
                </td>
            </tr>
            <tr>
                <td class="label">爱好：</td>
                <td class="controller">
                    <input type="checkbox" name="favorite" value="nba"/>NBA&nbsp;
                    <input type="checkbox" name="favorite" value="music"/>音乐&nbsp;
                    <input type="checkbox" name="favorite" value="movie"/>电影&nbsp;
                    <input type="checkbox" name="favorite" value="internet"/>上网&nbsp;
                </td>
            </tr>
            <tr>
                <td class="label">自我介绍：</td>
                <td class="controller">
                    <textarea name="introduce" rows="10" cols="40"></textarea>
                </td>
            </tr>
            <tr>
                <td class="label">接收协议：</td>
                <td class="controller">
                    <input type="checkbox" name="isAccept" value="true"/>是否卖身
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册"/>&nbsp;&nbsp;
                    <input type="reset" value="取消"/>&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
