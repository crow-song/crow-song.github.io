<%--<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>--%>
<%--<%@ page import="entity.Items"%>--%>
<%--<%@ page import="dao.ItemsDAO"%>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: ZHIEND--%>
  <%--Date: 2018/6/15--%>
  <%--Time: 14:38--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%--<html>--%>
  <%--<head>--%>
      <%--<script type="text/javascript" src="js/lhgcore.js"></script>--%>
      <%--<script type="text/javascript" src="js/lhgdialog.js"></script>--%>
      <%--<script type="text/javascript">--%>
          <%--&lt;%&ndash;function selflog_show(id){&ndash;%&gt;--%>
              <%--&lt;%&ndash;var num = document.getElementById("number").value;&ndash;%&gt;--%>
              <%--&lt;%&ndash;J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=request.getContextPath()%>/servlet/CartServlet?id='+id+'&num='+num+'&action=add', cover:true});&ndash;%&gt;--%>
          <%--&lt;%&ndash;}&ndash;%&gt;--%>
          <%--function selflog_show(id)--%>
          <%--{--%>
              <%--var num =  document.getElementById("number").value;--%>
              <%--J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=request.getContextPath()%>/servlet/CartServlet?id='+id+'&num='+num+'&action=add', cover:true});--%>
          <%--}--%>
      <%--</script>--%>
    <%--<style type="text/css">--%>
        <%--div{--%>
            <%--float:left;--%>
            <%--margin-left: 30px;--%>
            <%--margin-right:30px;--%>
            <%--margin-top: 5px;--%>
            <%--margin-bottom: 5px;--%>
        <%--}--%>
      <%--div dd{--%>
        <%--margin:0px;--%>
        <%--font-size:10pt;--%>
      <%--}--%>
      <%--div dd.dd_name--%>
      <%--{--%>
        <%--color:blue;--%>
      <%--}--%>
      <%--div dd.dd_city--%>
      <%--{--%>
        <%--color:#000;--%>
      <%--}--%>
    <%--</style>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<h1>商品展示</h1>--%>
  <%--<hr>--%>
  <%--<center>--%>
  <%--<table width="750" height="60" cellpadding="0" cellspacing="0" border="0" >--%>
    <%--<tr>--%>

        <%--<%--%>

          <%--ItemsDAO itemsDao = new ItemsDAO();--%>
          <%--Items item = itemsDao.getItemsById(Integer.parseInt(request.getParameter("id")));--%>
          <%--if(item!=null){--%>

        <%--%>--%>
       <%--<td width="70%" valign="top">--%>
        <%--&lt;%&ndash;商品循环开始&ndash;%&gt;--%>
        <%--<table>--%>
          <%--<dl>--%>
            <%--<tr>--%>
                <%--<td rowspan="4"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><B><%=item.getName()%></B></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>产地：<%=item.getCity()%></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>价格：<%=item.getPrice()%> ￥<td/>--%>
            <%--</tr>--%>

          <%--</dl>--%>
        <%--</table>--%>
           <%--<div id="cart">--%>
               <%--<img src="images/buy_now.png"><a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a><a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"/></a>--%>
               <%--&lt;%&ndash;<img src="images/buy_now.png"><a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a><a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"></a>&ndash;%&gt;--%>
           <%--</div>--%>
       <%--</td>--%>
        <%--<%--%>
          <%--}--%>
        <%--%>--%>


        <%--<%--%>
            <%--String list= "";--%>
            <%--Cookie [] cookies = request.getCookies();--%>

            <%--if(cookies!=null && cookies.length>0) {--%>
                <%--for (Cookie c : cookies) {--%>
                    <%--if (c.getName().equals("ListViewCookie")) {--%>
                        <%--list = c.getValue();--%>
                    <%--}--%>
                <%--}--%>
            <%--}--%>
            <%--list+=request.getParameter("id")+"#";--%>
                <%--//如果浏览记录超过1000，清零--%>
            <%--String [] arr = list.split("#");--%>
            <%--if(arr!=null && arr.length>0) {--%>
                <%--if (arr.length > 1000) {--%>
                    <%--//将存储cookie 的 list 清零;--%>
                    <%--list = "";--%>
                <%--}--%>
            <%--}--%>
            <%--Cookie cookie = new Cookie("ListViewCookie",list);--%>
            <%--response.addCookie(cookie);--%>

        <%--%>--%>
        <%--&lt;%&ndash;&lt;%&ndash;%>--%>
          <%--&lt;%&ndash;}&ndash;%&gt;--%>
        <%--&lt;%&ndash;%>&ndash;%&gt;--%>
      <%--<td width="30%" bgcolor="#EEE" align="center">--%>
          <%--<hr>--%>
          <%--<br>--%>
          <%--<b>您浏览过的商品</b><br>--%>
          <%--&lt;%&ndash;循环开始&ndash;%&gt;--%>
          <%--<%--%>
            <%--ArrayList<Items> itemlist = itemsDao.getViewList(list);--%>
            <%--if(itemlist!=null && itemlist.size()>0){--%>
                <%--for(Items i : itemlist){--%>
          <%--%>--%>
        <%--<div>--%>
          <%--<dl>--%>
            <%--<dt>--%>
                <%--<a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture()%>" width="120" height="90" border="1" /></a>--%>
            <%--</dt>--%>
            <%--<dd class="dd_name"><%=i.getName()%></dd>--%>
            <%--<dd class="dd_city">产地：<%=i.getCity()%>&nbsp;&nbsp;价格：￥<%=i.getPrice()%></dd>--%>
          <%--</dl>--%>
        <%--</div>--%>
          <%--<%--%>
                <%--}--%>
              <%--}--%>
          <%--%>--%>
          <%--&lt;%&ndash;循环结束&ndash;%&gt;--%>
      <%--</td>--%>

    <%--</tr>--%>
  <%--</table>--%>
  <%--</center>--%>
  <%--</body>--%>
<%--</html>--%>
















<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'details.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <script type="text/javascript">
        function selflog_show(id)
        {
            //此處4個 number 與 CartServlet 的 AddToCart 的 String number = request.getParameter("number"); 對應
            var number =  document.getElementById("number").value;
            J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/servlet/CartServlet?id='+id+'&number='+number+'&action=add', cover:true});
        }
        function add()
        {
            var num = parseInt(document.getElementById("number").value);
            if(num<100)
            {
                document.getElementById("number").value = ++num;
            }
        }
        function sub()
        {
            var num = parseInt(document.getElementById("number").value);
            if(num>1)
            {
                document.getElementById("number").value = --num;
            }
        }

    </script>

    <style type="text/css">
        hr{

            border-color:FF7F00;
        }

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
        div #cart
        {
            margin:0px auto;
            text-align:right;
        }
        span{
            padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>
<h1>商品详情</h1>
<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
<hr>
<center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <!-- 商品详情 -->
            <%
                ItemsDAO itemDao = new ItemsDAO();
                Items item = itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
                if(item!=null)
                {
            %>
            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td rowspan="5"><img src="images/<%=item.getPicture()%>" width="200" height="160"/></td>
                    </tr>
                    <tr>
                        <td><B><%=item.getName() %></B></td>
                    </tr>
                    <tr>
                        <td>产地：<%=item.getCity()%></td>
                    </tr>
                    <tr>
                        <td>价格：<%=item.getPrice() %>￥</td>
                    </tr>
                    <tr>
                        <td>购买数量：<span id="sub" onclick="sub();">-</span><input type="text" id="number" name="number" value="1" size="2"/><span id="add" onclick="add();">+</span></td>
                    </tr>
                </table>
                <div id="cart">
                    <img src="images/buy_now.png"><a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a><a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"/></a>
                </div>
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
            <!-- 浏览过的商品 -->
            <td width="30%" bgcolor="#EEE" align="center">
                <br>
                <b><font color="#FF7F00">您浏览过的商品</font></b><br>
                <!-- 循环开始 -->
                <%
                    ArrayList<Items> itemlist = itemDao.getViewList(list);
                    if(itemlist!=null&&itemlist.size()>0 )
                    {
                        System.out.println("itemlist.size="+itemlist.size());
                        for(Items i:itemlist)
                        {

                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture() %>" width="120" height="90" border="1"/></a>
                        </dt>
                        <dd class="dd_name"><%=i.getName() %></dd>
                        <dd class="dd_city">产地:<%=i.getCity() %>&nbsp;&nbsp;价格:<%=i.getPrice() %> ￥ </dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
                <!-- 循环结束 -->
            </td>
        </tr>
    </table>
</center>
</body>
</html>
