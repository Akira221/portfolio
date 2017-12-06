<%-- 
    Document   : registration
    Created on : 2017/11/20, 18:11:40
    Author     : user
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%

    HttpSession hs = request.getSession();
    UserData ud = (UserData) hs.getAttribute("ud");
    boolean reinput = false;
    if (request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")) {
        reinput = true;
        ud = (UserData) hs.getAttribute("ud");
    }


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
                <h1>会員登録画面</h1>
            </div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <br>
            <div class="form-group">
                <form action="Registration" method="POST"> 
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3">
                            ユーザー名 <input type="text" name="name" class="form-control"
                                         style="background-color: whitesmoke"  placeholder= "ユーザー名" value="<% if (reinput) {
                                                 out.print(ud.getName());}else{}%>">
                                             
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3">
                            パスワード <input type="text" name="password" class="form-control"
                                         style="background-color: whitesmoke"  placeholder="パスワード" value="<% if (reinput) {
                                                 out.print(ud.getPassword());
                                         }else{}%>">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3">
                            メールアドレス <input type="text" name="mail" class="form-control"
                                           style="background-color: whitesmoke"  placeholder="メールアドレス" value="<% if (reinput) {
                                                   out.print(ud.getMail());
                                           } else {}%>">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3">
                            住所 <textarea name="address" class="form-control"
                                         style="background-color: whitesmoke"  placeholder="住所"><% if (reinput) {
                                                 out.print(ud.getAddress());
                                             } else {}%></textarea>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-3">

                            <button type="submit" class="btn btn-info">登録確認</button>
                        </div>
                    </div>
                </form>

            </div>
    </body>
</html>
