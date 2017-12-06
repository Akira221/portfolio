<%-- 
    Document   : myhistry
    Created on : 2017/12/01, 16:14:02
    Author     : user
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jums.ApiData"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<ApiData> buyHistry = (ArrayList<ApiData>) session.getAttribute("buyHistry");

    ArrayList<ApiData> buyArray = (ArrayList<ApiData>) session.getAttribute("buyArray");
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
                <h1>購入履歴</h1>
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
        <div class="col-sm-9" style="background-color: blue"></div>
    </div>
    <%=jh.home()%><br><br>
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-8">
            <div class="container">
                <table class="table table-bordered table-responsive table-striped">
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
                            Date date = buyArray.get(i).getDate();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                            out.print(sdf.format(date));
                            %></td><%}
                            %> 
                    </tr></table></div></div></div>
                    <%=jh.home()%>
</body>
</html>
