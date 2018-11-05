<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/22
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userinfo</title>
    <style>
        .title{
            width:30%;
            background-color:#ccc;
            font-weight:bold;
        }
        .content{
            width:70%;
            background-color:#CBCFE5;
        }
    </style>
</head>
<body>
    <h1>用户信息</h1>
    <hr>
    <center>
        <%--用javaBean获取信息；id与setAttribute("regUser",u)；中的regUser相对应；class与Bean(Users)类对应--%>
        <jsp:useBean scope="session" id="regUser" class="entity.Users" />
        <table width="600" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td class="title">用户名：</td>
                <%--name 与 useBran 中的 id 对应--%>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="username"/></td>
            </tr>
            <tr>
                <td class="title">密码：</td>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="mypassword"/></td>
            </tr>
            <tr>
                <td class="title">性别：</td>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="gender"/></td>
            </tr>
            <tr>
                <td class="title">E-mail：</td>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="email"/></td>
            </tr>
            <tr>
                <td class="title">出生日期：</td>
                <td class="content">&nbsp;
                    <%
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                        String date = sdf.format(regUser.getBirthday());

                    %>
                    <%=date%>
                </td>
            </tr>
            <tr>
                <td class="title">爱好：</td>
                <td class="content">&nbsp;
                    <%
                        String [] favorite = regUser.getFavorite();
                        for(String f : favorite){


                    %>
                    <%=f%>&nbsp;
                    <%
                        }
                    %>
                </td>
            </tr>
            <tr>
                <td class="title">自我介绍：</td>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="introduce"/></td>
            </tr>
            <tr>
                <td class="title">是否接受协议：</td>
                <td class="content">&nbsp;<jsp:getProperty name="regUser" property="flag"/></td>
            </tr>
        </table>
    </center>
</body>
</html>
