<%-- 
    Document   : mydata
    Created on : 2017/12/01, 13:20:15
    Author     : user
--%>
<%@page import="jums.UserDataDTO"
        import="jums.JumsHelper"
        import= "javax.servlet.http.HttpSession"
        import=" java.text.SimpleDateFormat"
        import=" java.util.Date"%>
<%
    HttpSession hs = request.getSession();
    UserDataDTO ud;
    ud = (UserDataDTO) hs.getAttribute("ud");
    Date date = null;
    date = ud.getDate();
    JumsHelper jh = JumsHelper.getInstance();
%>
<%! //        date = ud.getDate();登録日時をSimpleDateFormatでフォーマット  %>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");

    String sdfDate = sdf.format(date);
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
                <h1>ユーザー登録情報</h1>
            </div>
            <div class="col-sm-3">
                <%
                    String name = (String) session.getAttribute("name");
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
    <br>
    <div class="row"> 
        <div class="col-sm-1"></div>
        <div class="col-sm-8">
            <table class="table table-bordered table-responsive table-striped">
                <tr>
                    <th>ユーザー名</th>              
                    <th>パスワード</th>
                    <th>メールアドレス</th>
                    <th>住所</th>
                    <th>総購入金額</th>
                    <th>登録日</th>
                </tr>

                <tr>  
                    <td><%=ud.getName()%></td>
                    <td><%=ud.getPassword()%></td>
                    <td><%=ud.getMail()%></td>
                    <td><%=ud.getAddress()%></td>
                    <td><%=ud.getTotal()%>円</td>
                    <td><%=sdfDate%></td>
                </tr></table></div></div><br>
    <div class="row">
        <div class="col-sm-1"></div>
        <form action="Myhistry" method="POST">
            <button type="submit" class="btn btn-primary">購入履歴</button>
        </form>
        <form action="Myupdate" method="POST">
            <button type="submit" class="btn btn-info">登録情報更新</button>
        </form>
        <form action="Mydelete" method="POST">
            <button type="submit" class="btn btn-danger">登録情報削除</button>
        </form>

    </div>
    <br>

    <div class="row">
        <div class="col-sm-1"></div>
        <%=jh.home()%>
    </div>
</body>
</html>
