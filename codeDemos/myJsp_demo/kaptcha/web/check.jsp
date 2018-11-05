<%@ page import="com.google.code.kaptcha.Constants" %><%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String k = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
    String str = request.getParameter("r");
    if(k.equals(str))
        out.print("true");
    out.print( k + "----" + str);
%>
