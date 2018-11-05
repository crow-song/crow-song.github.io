<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/12
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<jsp:useBean id="loginUser" class="com.po.Users" scope="page"/>
<jsp:useBean id="userDAO" class="com.dao.UsersDAO" scope="page" />
<jsp:setProperty  property="*" name="loginUser" />
<%
//    String username = "";
//    String password = "";

    request.setCharacterEncoding("utf-8");
//    username = request.getParameter("username");
//    password = request.getParameter("password");

//    if("admin".equals(username)&&"admin".equals(password)){
    if(userDAO.userLogin(loginUser)){
        session.setAttribute("loginUser",loginUser.getUsername());
        request.getRequestDispatcher("login_success.jsp").forward(request,response);
    }
    else{
        response.sendRedirect("login_failure.jsp");
    }
%>
