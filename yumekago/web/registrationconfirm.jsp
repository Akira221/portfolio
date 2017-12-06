<%-- 
    Document   : registrationconfirm
    Created on : 2017/11/20, 20:09:17
    Author     : user
--%>

<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData ud = (UserData) hs.getAttribute("ud");
    ArrayList<String> chkList = ud.chkproperties();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認画面</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">

            <% if (chkList.size() == 0) {%>
            <div class="row">
                <div class="col-sm-1"></div>
                <h1>登録確認</h1>
            </div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <font size="5">
                    名前:<%= ud.getName()%><br>
                    パスワード:<%= ud.getPassword()%><br>
                    メールアドレス:<%= ud.getMail()%><br>
                    住所:<%= ud.getAddress()%><br>

                    上記の内容で登録します。よろしいですか？</font>
                    <form action="Registrationcomplete" method="POST">

                        <button type="submit" name="yes" class="btn btn-info">はい</button>
                    </form><br>
                    <form action="registration.jsp" method="POST">
                        <button type="submit" name="no" class="btn btn-info">いいえ</button>
                        <input type="hidden" name="mode" value="REINPUT">
                    </form>
                </div>
            </div>
            <% } else {%>
            <div class="row">
                <div class="col-sm-1"></div>
                <h1>入力が不完全です</h1>
            </div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>

                <a href="registration.jsp?mode=REINPUT"><font size="5"><%=jh.chkinput(chkList)%></font></a>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="form-group">
                    <form action="registration.jsp" method="POST">
                        <button type="submit" name="no" class="btn btn-info">登録画面に戻る</button>
                        <input type="hidden" name="mode" value="REINPUT">
                    </form>
                    <% }%>
                </div>
                <!--    </form>-->
            </div>
    </body>
</html>

