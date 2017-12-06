<%-- 
    Document   : search
    Created on : 2017/11/26, 17:34:03
    Author     : user
--%>
<%@page import="jums.ApiData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    ArrayList<ApiData> udd = (ArrayList<ApiData>) session.getAttribute("resultData");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索結果表示</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div  class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8">
                    <h1>商品一覧</h1></div>
                <div class="col-sm-3">
                    <%            String logCh = (String) session.getAttribute("logCh");
                        String name = (String) session.getAttribute("name");
                    %>
                    <% if ("in".equals(logCh)) {
                            out.print(name + "さん" + "ようこそ!" + "<br>"); %>
                   
                    <form action="Logout" method="POST">
                        <button type="submit"  class="btn btn-info btn-sm" >ログアウト</button>
                    </form>

                    <%} else {%>

                    <form action="login.jsp" method="post">
                        <input type="hidden" name="pageNum" value="3">
                        <button type="submit"  class="btn btn-info btn-sm" >ログイン</button>

                    </form>


                    <%}%>
                </div>            
            </div>
            <div class="row">
                <div class="col-sm-9" style="background-color:blue;"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-3" style="background-color: yellow;"> 検索キーワード:<%=session.getAttribute("key")%></div>

            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-3" style="background-color:whitesmoke;">
                検索結果数:<%=session.getAttribute("totalResult")%>件</div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-8"> 
                    <div class="table-responsive">
                        <table border=1 class="table table-bordered">
                            <tr>
                                <th>画像</th>
                                <th>商品名</th>
                                <th>価格</th>

                            </tr>
                            <%for (int i = 0; i < udd.size(); i++) {%>
                            <tr>
                                <td><img id="<%= udd.get(i).getId()%>" src="<%=udd.get(i).getMedium()%>"></img></td>
                                <td><a href="Item?item=<%= udd.get(i).getItemCode()%>"><%= udd.get(i).getName()%></a></td>
                                <td><%= udd.get(i).getPrice()%>円</td>


                            </tr>
                            <%}%>
                            <%=jh.home()%>
                            <%if (udd.size() == 0) {
                                    out.print("該当するデータはありません");
                                }%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
