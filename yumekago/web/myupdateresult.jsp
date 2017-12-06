<%-- 
    Document   : myupdateresult
    Created on : 2017/12/01, 18:45:39
    Author     : user
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%
    UserDataDTO ud;
    ud = (UserDataDTO) session.getAttribute("UserData");
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
                    <h1>更新完了</h1>
                </div>
                <div class="col-sm-3">
                    <%                    String name = (String) session.getAttribute("name");
                        out.print(name + "さんこんにちは！");
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
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-8">
                <font size="5">
                ユーザー名:<%=ud.getName()%><br><br>
                パスワード:<%=ud.getPassword()%><br><br>
                メールアドレス:<%=ud.getMail()%><br><br>
                住所:<%=ud.getAddress()%><br><br>

                以上の内容で更新しました。<br>
                <%=jh.home()%>
                </font>

            </div>
        </div>
    </div>
</body>
</html>
