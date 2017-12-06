<%-- 
    Document   : buycomplete
    Created on : 2017/11/30, 1:01:46
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
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-8">
                <h1>購入が完了しました。</h1>
            </div>
            <div class="col-sm-3">
                <% String name = (String) session.getAttribute("name");
                    out.print(name + "さんようこそ！");
                %>
                <form action="Logout" method="POST">
                    <div class="form-group">
                        <button type="submit" value="ログアウト"class="btn btn-info">ログアウト</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8" style="background-color: blue"></div>
    </div><br>
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-8">
            <form action="Mydata" method="POST">
                <button type="submit" class="btn btn-warning">登録情報確認</button>
            </form><br>
            <%=jh.home()%>
        </div>
    </div>
</body>
</html>
