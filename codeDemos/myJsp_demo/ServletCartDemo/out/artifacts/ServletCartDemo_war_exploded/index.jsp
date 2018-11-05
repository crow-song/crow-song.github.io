<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/15
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="dao.ItemsDAO" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="entity.Items" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
  <head>
    <style type="text/css">
      div{
        float:left;
        margin: 10px;
      }
      div dd{
        margin:0px;
        font-size:10pt;
      }
      div dd.dd_name
      {
        color:blue;
      }
      div dd.dd_city
      {
        color:#000;
      }
    </style>
  </head>
  <body>
  <h1>商品展示</h1>
  <hr>
  <center>
  <table width="750" height="60" cellpadding="0" cellspacing="0" border="0" >
    <tr>
      <td>
        <%

          ItemsDAO itemsDao = new ItemsDAO();
          ArrayList<Items> list = itemsDao.getAllItems();
          if(list!=null&&list.size()>0){
          for(int i=0; i<list.size();i++){
              Items item = list.get(i);

        %>

        <%--商品循环开始--%>
        <div>
          <dl>
            <dt>
                <%--将图片链接到详细细节页面--%>
              <a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1" /></a>
            </dt>
            <dd class="dd_name"><%=item.getName()%></dd>
            <dd class="dd_city">产地：<%=item.getCity()%>&nbsp;&nbsp;价格：<%=item.getPrice()%></dd>
          </dl>
        </div>
        <%
            }
          }
        %>
        <%--&lt;%&ndash;%>
          <%--}--%>
        <%--%>--%>
        <%--<div>--%>
          <%--<dl>--%>
            <%--<dt>--%>
              <%--<img src="images/003.jpg" width="120" height="90" border="1" />--%>
            <%--</dt>--%>
            <%--<dd class="dd_name">耐克运动鞋</dd>--%>
            <%--<dd class="dd_city">产地：福州&nbsp;&nbsp;价格：￥500</dd>--%>
          <%--</dl>--%>
        <%--</div>--%>
        <%--<div>--%>
          <%--<dl>--%>
            <%--<dt>--%>
              <%--<img src="images/004.jpg" width="120" height="90" border="1" />--%>
            <%--</dt>--%>
            <%--<dd class="dd_name">阿迪达斯T血衫</dd>--%>
            <%--<dd class="dd_city">产地：上海&nbsp;&nbsp;价格：￥388</dd>--%>
          <%--</dl>--%>
        <%--</div>--%>
        <%--<div>--%>
          <%--<dl>--%>
            <%--<dt>--%>
              <%--<img src="images/005.jpg" width="120" height="90" border="1" />--%>
            <%--</dt>--%>
            <%--<dd class="dd_name">李宁文化衫</dd>--%>
            <%--<dd class="dd_city">产地：广州&nbsp;&nbsp;价格：￥180</dd>--%>
          <%--</dl>--%>
        <%--</div>--%>

      </td>
    </tr>
  </table>
  </center>
  </body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>商品展示</h1>--%>
<%--<hr>--%>


  <%--<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">--%>
    <%--<tr>--%>
      <%--<td>--%>

        <%--<!-- 商品循环开始 -->--%>
        <%--<%--%>

          <%--ItemsDAO itemsDao = new ItemsDAO();--%>
          <%--ArrayList<Items> list = itemsDao.getAllItems();--%>
          <%--if(list!=null&&list.size()>0)--%>
          <%--{--%>
            <%--for(int i=0;i<list.size();i++)--%>
            <%--{--%>
              <%--Items item = list.get(i);--%>
        <%--%>--%>
        <%--<div>--%>
          <%--<dl>--%>
            <%--<dt>--%>
              <%--<a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1"/></a>--%>
            <%--</dt>--%>
            <%--<dd class="dd_name"><%=item.getName() %></dd>--%>
            <%--<dd class="dd_city">产地:<%=item.getCity() %>&nbsp;&nbsp;价格:￥ <%=item.getPrice() %></dd>--%>
          <%--</dl>--%>
        <%--</div>--%>
        <%--<!-- 商品循环结束 -->--%>

        <%--<%--%>
            <%--}--%>
          <%--}--%>
        <%--%>--%>
      <%--</td>--%>
    <%--</tr>--%>
  <%--</table>--%>

<%--</body>--%>
<%--</html>--%>