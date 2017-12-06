<%-- 
    Document   : item
    Created on : 2017/11/27, 17:55:06
    Author     : user
--%>
<%@page import="jums.ApiData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    ApiData udd = new ApiData();
    udd = (ApiData) session.getAttribute("itemSerch");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-2">
                    <h1>商品詳細</h1></div>
                <div class="col-sm-6">
                    <font size="5"> <%= udd.getName()%></font></div>
                <div class="col-sm-3">
                    <%
                        String logCh = (String) session.getAttribute("logCh");
                        String name = (String) session.getAttribute("name");
                    %>

                    <% if ("in".equals(logCh)) {
                            out.print(name + "さん" + "ようこそ!" + "<br>"); %>

                    <form action="Logout" method="POST">
                        <button type="submit"  class="btn btn-info btn-sm">ログアウト</button>
                    </form>

                    <%} else {%>

                    <form action="login.jsp" method="post">
                        <input type="hidden" name="pageNum" value="4">
                        <button type="submit"  class="btn btn-info btn-sm">ログイン</button>

                    </form>
                    <%}%>
                </div></div>
            <div class="row">
                <div class="col-sm-9" style="background-color:blue;"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">

                </div>
            </div><br>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-2"> 
                    <img id="<%= udd.getId()%>" src="<%=udd.getMedium()%>"></img><br><br>
                    <label> <font size="20">￥<%= udd.getPrice()%></font></label><br>
                    <label> <font size="5"> 評価（5段階）<br>
                        <% if (!udd.getRate().equals("")) {
                                out.print(udd.getRate());
                            }else{%>評価なし<%}%></font></label>
                    <form action="Add" method="POST">
                        <div class="form-group">
                            <input type="hidden" name="cartName" value="<%= udd.getName()%>">
                            <input type="hidden" name="cartPrice" value="<%= udd.getPrice()%>">
                            <input type="hidden" name="cartId" value="<%= udd.getId()%>">
                            <input type="hidden" name="cartImage" value="<%= udd.getMedium()%>">
                            <input type="hidden" name="cartItemCode" value="<%= udd.getItemCode()%>">
                            <button type="submit"  class="btn btn-info btn-xs">カートに追加する</button>
                        </div>
                    </form>
                </div>
                <div class="col-sm-6">

                    <%= udd.getCaption()%></div>


                </body>
                </html>
