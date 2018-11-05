
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/7/6
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>number</title>
  </head>
  <body>
  当前在线用户人数：${userNumber}<br/>

  <%
      ArrayList<com.imooc.entity.User> userList = (ArrayList<com.imooc.entity.User>)request.getServletContext().getAttribute("userList");
      if(userList!=null){
          for(int i=0;i<userList.size();i++){
            com.imooc.entity.User  user = userList.get(i);
  %>

  IP:<%=user.getIpString()%><br/>
  SessionID:<%=user.getSessionIdString()%><br/>
  FirstTime:<%=user.getFirstTimeString()%><br/>


  <%
          }
      }
  %>
  </body>
</html>
