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

<html>
  <head>
    <style type="text/css">
        div{
            float:left;
            margin-left: 30px;
            margin-right:30px;
            margin-top: 5px;
            margin-bottom: 5px;
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

        <%

          ItemsDAO itemsDao = new ItemsDAO();
          Items item = itemsDao.getItemsById(Integer.parseInt(request.getParameter("id")));
          if(item!=null){

        %>
       <td width="70%" valign="top">
        <%--商品循环开始--%>
        <table>
          <dl>
            <tr>
                <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1" /></td>
            </tr>
            <tr>
                <td><B><%=item.getName()%></B></td>
            </tr>
            <tr>
                <td>产地：<%=item.getCity()%></td>
            </tr>
            <tr>
                <td>价格：<%=item.getPrice()%> ￥<td/>
            </tr>
          </dl>
        </table>
       </td>
        <%
          }
        %>


        <%
            String list= "";
            Cookie [] cookies = request.getCookies();

            if(cookies!=null && cookies.length>0) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("ListViewCookie")) {
                        list = c.getValue();
                    }
                }
            }
            list+=request.getParameter("id")+"#";
                //如果浏览记录超过1000，清零
            String [] arr = list.split("#");
            if(arr!=null && arr.length>0) {
                if (arr.length > 1000) {
                    //将存储cookie 的 list 清零;
                    list = "";
                }
            }
            Cookie cookie = new Cookie("ListViewCookie",list);
            response.addCookie(cookie);

        %>
        <%--&lt;%&ndash;%>
          <%--}--%>
        <%--%>--%>
      <td width="30%" bgcolor="#EEE" align="center">
          <hr>
          <br>
          <b>您浏览过的商品</b><br>
          <%--循环开始--%>
          <%
            ArrayList<Items> itemlist = itemsDao.getViewList(list);
            if(itemlist!=null && itemlist.size()>0){
                for(Items i : itemlist){
          %>
        <div>
          <dl>
            <dt>
                <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture()%>" width="120" height="90" border="1" /></a>
            </dt>
            <dd class="dd_name"><%=i.getName()%></dd>
            <dd class="dd_city">产地：<%=i.getCity()%>&nbsp;&nbsp;价格：￥<%=i.getPrice()%></dd>
          </dl>
        </div>
          <%
                }
              }
          %>
          <%--循环结束--%>
      </td>

    </tr>
  </table>
  </center>
  </body>
</html>

