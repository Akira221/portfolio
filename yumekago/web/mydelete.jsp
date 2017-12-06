<%-- 
    Document   : myhistry
    Created on : 2017/12/01, 16:14:02
    Author     : user
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jums.ApiData"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<ApiData> buyHistry = (ArrayList<ApiData>) session.getAttribute("buyHistry");

    ArrayList<ApiData> buyArray = (ArrayList<ApiData>) session.getAttribute("buyArray");
    UserDataDTO ud = (UserDataDTO) session.getAttribute("UserData");
    Date date = null;
    date = ud.getDate();
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <h1>会員情報削除画面</h1>
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
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-8">
                <div class="table-responsive">
                    <table border=1 class="table table-bordered">
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
                        </tr></table><br>
                </div>
            </div>
        </div>
    </table>
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-8">
            <div class="table-responsive">
                <table border=1 class="table table-bordered table-striped">
                    <tr>
                        <th>画像</th>
                        <th>商品名</th>
                        <th>価格</th>
                        <th>購入日</th>
                    </tr>
                    <% for (int i = 0; i < buyHistry.size(); i++) {%>
                    <tr>
                        <td><img id="<%=buyHistry.get(i).getId()%>" src="<%=buyHistry.get(i).getMedium()%>"</td>
                        <td><%=buyHistry.get(i).getName()%></td>
                        <td><%=buyHistry.get(i).getPrice()%>円</td>
                        <td><%
                            Date date2 = buyArray.get(i).getDate();
                            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
                            out.print(sdf2.format(date2));
                            %></td><%}
                            %> 
                    </tr></table>
                <br><br>
                このユーザーをマジで削除しますか？<br><br>
                <a href="Mydeleteresult">はい</a><br><br>
                <a href="top.jsp">いいえ</a><br><br>
            </div>
        </div>
    </div>
</div>
</body>
</html>
