<%-- 
    Document   : login
    Created on : 2017/11/22, 15:48:41
    Author     : user
--%>
<%response.setContentType("text/html;charset=UTF-8");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <h1>ログインページ</h1>
                </div>

            </div>
            <div class="row">
                <div class="col-sm-8" style="background: blue"></div>
            </div>
            <br><br>
            <form action="Login" method="post">
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-3">

                        <div class="form-group">

                            <input type="text" name="name" class="form-control" style="background-color: whitesmoke" id="exampleInputUserName" placeholder="ユーザー名">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-3">

                        <div class="form-group">

                            <input type="password" name="password" class="form-control" style="background-color: whitesmoke" id="exampleInputPassword" placeholder="パスワード">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-3">
                        <input type="hidden" name="pageNum" value="<%=request.getParameter("pageNum")%>">
                        <button type="submit" class="btn btn-info btn-sm">ログイン</button>
                        </form></div></div><br>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-3">
                        <form action="registration.jsp" method="POST">
                            <button type="submit" class="btn btn-info btn-sm">新規会員登録</button>

                        </form>
                    </div>
                </div>
        </div>
    </body>
</html>
