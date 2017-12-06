<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserData" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData) request.getAttribute("ud");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録結果画面</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <h1>登録結果</h1><br>
            </div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <font size="5">
                    ユーザー名:<%= ud.getName()%><br>
                    パスワード:<%= ud.getPassword()%><br>
                    メール:<%= ud.getMail()%><br>
                    住所:<%= ud.getAddress()%><br>

                    以上の内容で登録しました。<br>
                    <%=jh.home()%>
                    </font>
                </div>
            </div>
        </div>
    </body>

</html>
