<%-- Created by IntelliJ IDEA.
 User: ZHIEND
 Date: 2018/6/14
 Time: 15:22
 To change this template use File | Settings | File Templates.
--%>
  <%@ page import="java.util.Date" %>
  <%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
    String s = sdf.format(d);
    out.println(s);
%>