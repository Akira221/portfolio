<%-- 
    Document   : registration
    Created on : 2017/11/20, 18:11:40
    Author     : user
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%

    HttpSession hs = request.getSession();
    UserDataDTO ud = (UserDataDTO) hs.getAttribute("UserData");

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
                <h1>会員登録情報更新ページ</h1>
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
        <div class="col-sm-9" style="background-color: blue"></div>
    </div>
    <%=jh.home()%><br><br>
    <br>
    <form action="Myupdateresult" method="POST"> 
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>ユーザー名</label>
                    <input type="text" class="form-control"  name="name" value="<%=ud.getName()%>">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>パスワード</label>
                    <input type="password" class="form-control"  name="password" value="<%=ud.getPassword()%>">
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>メールアドレス</label>
                    <input type="text" class="form-control"  name="mail" value="<%=ud.getMail()%>">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>住所</label>
                    <textarea  class="form-control" name="address" ><%=ud.getAddress()%></textarea>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <div class="form-group">
                    <button type="submit" class="btn btn-info">送信</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
