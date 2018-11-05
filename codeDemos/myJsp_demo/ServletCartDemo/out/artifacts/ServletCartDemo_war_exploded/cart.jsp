<%--
  Created by IntelliJ IDEA.
  User: ZHIEND
  Date: 2018/6/28
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Cart"%>
<%@ page import="entity.Items"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
    <title>Title</title>
    <%--导入 css 的 css 前也要加 /--%>
    <link type="text/css" rel="stylesheet" href="/css/style1.css" />

    <script language="JavaScript">
        // 确认对话框
    function delcfm(){
        if(!confirm("确认删除吗？")){
            window.event.returnValue = false;
        }
    }
    </script>
</head>
<body>
    <h1>我的购物车</h1>
    <a href="/index.jsp">首页</a> <a href="index.jsp">商品列表</a>
    <hr>
    <div id="shopping">
        <form action="">
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品单价</th>
                    <th>商品总价</th>
                    <th>购买数量</th>
                    <th>操作</th>
                </tr>


                <%
                    if(request.getSession().getAttribute("cart")!=null){

                %>
                <%--循环开始--%>
                <%
                    Cart cart = (Cart)request.getSession().getAttribute("cart");
                    HashMap<Items,Integer> goods = cart.getGoods();
                    Set<Items> items = goods.keySet();
                    Iterator<Items> it = items.iterator();
                    while(it.hasNext()){
                        Items i = it.next();
                %>
                <tr name="products" id="product_id_1">
                    <td class="thumb"><img src="/images/<%=i.getPicture()%>" /> <a href=""><%=i.getName()%></a></td>
                    <td class="number"><%=i.getPrice()%></td>
                    <td class="price" id="price_id_1">
                        <span><%=i.getPrice()*goods.get(i)%></span>
                        <%--<input tyep="hidden" value="" />--%>
                    </td>
                    <td class="number">
                        <%=goods.get(i)%>
                    </td>
                    <td class="delete">
                        <a href="/servlet/CartServlet?action=delete&id=<%=i.getId()%>" onclick="delcfm()">删除</a>
                    </td>
                </tr>
                <%--循环结束--%>

                <%
                    }
                %>

            </table>

            <div class="total"><span id="total">总计：<%=cart.getTotalPrice()%>￥</span></div>
            <%
                }
            %>
        </form>
    </div>


</body>
</html>
