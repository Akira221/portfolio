<%-- 
    Document   : buyconfirm
    Created on : 2017/11/29, 17:29:08
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
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-7">
                <h1>購入内容確認</h1>
            </div>
            <div class="col-sm-3">  
                <%  String name = (String) session.getAttribute("name");
                    out.print(name + "さん" + "ようこそ!" + "<br>"); %>
                <form action="Logout" method="POST">

                    <button type="submit" class="btn btn-info">ログアウト</button>
                </form>
            </div></div>
            <div class="row">
                <div class="col-sm-9" style="background-color: blue"></div>
            </div><br>

            <%int total = 0;%>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <div class="container">
                        <table class="table table-bordered table-responsive table-striped">
                            <thead>
                                <tr>

                                    <th>商品名</th>

                                    <th>価格</th>

                                </tr>
                                <% for (int i = 0; i < cartArray.size(); i++) {%>
                                <tr>  

                                    <td><%= cartArray.get(i).getName()%></a></td>
                                    <td><%= cartArray.get(i).getPrice()%>円</td>



                                    <%}%></tr></thead></table></div></div></div><br>

            <%

                for (int i = 0; i < cartArray.size(); i++) {
                    int num = cartArray.get(i).getPrice();
                    total += num;

                }

            %>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <div class="container">
                        <table class="table table-bordered table-responsive table-striped">
                            <thead>
                                <tr>
                                    <th>合計金額</th>
                                </tr>
                                <tr>
                                    <td><%=total%>円</td></tr></thead></table>
                        <form action="Buycomplete" method="POST">
                            発送方法:
                            <br>
                            <% for (int i = 1; i <= 2; i++) {%>
                            <input type="radio" name="type" value="<%=i%>"><%=jh.exTypenum(i)%><br>
                            <% }%>
                            <br>
                            <input type="hidden" name="total" value="<%=total%>">
                            <button type="submit" class="btn btn-success btn-lg">上記の内容で購入する</button>
                        </form><br>
                        <form action="cart.jsp" method="POST">
                            <button type="submit" class="btn btn-info">カートに戻る</button>
                        </form></div>
                    </body>
                    </html>
