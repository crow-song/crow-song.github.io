<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/13
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.net.*"%>
<html>
<head>
    <title>dologin</title>
</head>
<body>
    <h1>登录成功</h1>
    <hr>
    <br>
    <br>
    <br>

    <%
        request.setCharacterEncoding("utf-8");
        //判断用户是否选择记住登录状态
        String [] isUseCookies = request.getParameterValues("isUseCookie");
        if(isUseCookies!=null && isUseCookies.length>0){
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");

            //使用 URLEncoder 解决 Cookie 中文乱码问题
            String username = URLEncoder.encode(request.getParameter("username"),"utf-8");
            String password = URLEncoder.encode(request.getParameter("password"),"utf-8");


            Cookie usernameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password",password);
            usernameCookie.setMaxAge(60*60*24*10);
            passwordCookie.setMaxAge(60*60*24*10);//设置最大生存期限10天
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        else{
            Cookie [] cookies = request.getCookies();
            if(cookies!=null && cookies.length>0){
                for(Cookie c : cookies){
                    if(c.getName().equals("username") || c.getName().equals("password")){
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
        }
    %>
    <a href="users.jsp" target="_blank">查看用户信息</a>
</body>
</html>
