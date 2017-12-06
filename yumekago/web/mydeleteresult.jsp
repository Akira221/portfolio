<%-- 
    Document   : mydeleteresult
    Created on : 2017/12/01, 20:11:50
    Author     : user
--%>
<%@page import="jums.JumsHelper" %>

<%JumsHelper jh = JumsHelper.getInstance();
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
                <h1>削除しました</h1>
            </div>
            <div class="row">
                <div class="col-sm-8" style="background-color: blue"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-1"></div>
                <font size="5">
                <%=jh.home()%>   
            </div>
        </div>
    </body>
</html>
