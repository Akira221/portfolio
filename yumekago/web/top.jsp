<%-- 
    Document   : top
    Created on : 2017/11/20, 17:23:58
    Author     : user
--%>

<%@page import="jums.UserData"
        import="javax.servlet.http.HttpSession"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <h1>Kagoyumeトップページ</h1></div>
                    <%

                        String logCh = (String) session.getAttribute("logCh");
                        String name = (String) session.getAttribute("name");
                    %> 
                <div class="col-sm-3">  
                    <% if ("in".equals(logCh)) {
                            out.print(name + "さん" + "ようこそ!" + "<br>"); %>
                    <form action="Logout" method="POST">
                        <div class="form-group">
                            <button type="submit" value="ログアウト"class="btn btn-info">ログアウト</button>
                    </form>

                    <%} else {%>

                    <form action="login.jsp" method="post">
                        <input type="hidden" name="pageNum" value="1">
                        <button type="submit" value="ログイン" class="btn btn-info">ログイン</button>

                    </form>
                    <%}%>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-8" style="background-color:blue;"></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            好きなものを好きなだけ買ったきになれる通販サイトです。<br><br>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <form action="Search" method="GET">
                <div class="form-group">
                    <label for="exampleInputkeyword">商品検索</label>
                    <input type="text" class="form-control" name="key"　id="exampleInputkeyword" placeholder="商品名を入力してください">
                </div>

        </div>
    </form><br><br></div>



</div>

</div>
</body>
</html>
