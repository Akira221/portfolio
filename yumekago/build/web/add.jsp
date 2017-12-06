<%-- 
    Document   : add
    Created on : 2017/11/27, 19:17:35
    Author     : user
--%>

<%@page import="jums.JumsHelper"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();


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
                    <h1>商品をカートに追加しました！</h1></div>
                <div class="col-sm-3">
                    <%             String logCh = (String) session.getAttribute("logCh");
                        String name = (String) session.getAttribute("name");
                    %>
                    <% if ("in".equals(logCh)) {
                            out.print(name + "さん" + "ようこそ!" + "<br>"); %>

                    <form action="Logout" method="POST">
                        <button type="submit"  class="btn btn-info btn-sm">ログアウト</button>
                    </form>
                </div>
                <%} else {%>

                <form action="login.jsp" method="post">
                    <input type="hidden" name="pageNum" value="2">
                    <button type="submit"  class="btn btn-info btn-sm">ログイン</button>

                </form>
                <%}%></div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-1"></div>
                <a href="Cart">カートを確認する</a><br><br>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <%=jh.home()%>
            </div>
        </div>
    </body>
</html>
