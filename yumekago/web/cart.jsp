<%-- 
    Document   : cart
    Created on : 2017/11/29, 15:49:26
    Author     : user
--%>
<%@page import="jums.ApiData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    ArrayList<ApiData> cartArray = (ArrayList<ApiData>) session.getAttribute("cartArray");
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
                <div class="col-sm-8">
                    <h1>カート内表示</h1></div>
                <div class="col-sm-3">
                    <%
                        String logCh = (String) session.getAttribute("logCh");
                        String name = (String) session.getAttribute("name");
                    %>
                    <% if ("in".equals(logCh)) {
                            out.print(name + "さん" + "ようこそ!" + "<br>"); %>

                    <form action="Logout" method="POST">
                        <button type="submit" class="btn btn-info">ログアウト</button>
                    </form>

                    <%} else {%>

                    <form action="login.jsp" method="post">
                        <input type="hidden" name="pageNum" value="5">
                        <button type="submit" class="btn btn-info">ログイン</button>

                    </form>
                    <%}%>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-9" style="background-color: blue"></div>
            </div><br>
            <%int total = 0;%>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <div class="container">
                        <table class="table-responsive table-striped table-bordered">
                            <tr>
                                <th>画像</th>
                                <th>商品名</th>

                                <th>価格</th>
                                <th></th>
                            </tr>
                            <% for (int i = 0; i < cartArray.size(); i++) {%>
                            <tr>  
                                <td><img id="<%= cartArray.get(i).getId()%>" src="<%=cartArray.get(i).getMedium()%>"></img></td>
                                <td><a href="Item?item=<%= cartArray.get(i).getItemCode()%>"><%= cartArray.get(i).getName()%></a></td>
                                <td><%= cartArray.get(i).getPrice()%>円</td>
                                <td><a href="Delete?cartNum=<%=i%>">削除</a></td>


                                <%}%></tr></table><br>

                        <%

                            for (int i = 0; i < cartArray.size(); i++) {
                                int num = cartArray.get(i).getPrice();
                                total += num;

                            }

                        %>
                        <div class="row">

                            <table class="table-responsive table-striped table-bordered">

                                <tr>
                                    <th>合計金額</th>
                                </tr>
                                <tr>
                                    <td><%=total%>円</td></tr></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-3">
                <form action="buyconfirm.jsp" method="POST">
                    <button type="submit" class="btn btn-success btn-lg">購入する</button>
                </form>
                <%=jh.home()%>
            </div></div>
    </body>
</html>
