<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/") + 1);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css"/>

        <script>
            $(document).ready(function () {
                $("table").DataTable();
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">IT355</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <c:url var="index"  value="/" />
                            <c:url var="add"  value="/addProduct/" />
                            <c:url var="see"  value="/seeproducts/" />
                            <c:url var="addcat"  value="/addCategory/" />
                            <li class="<%=  (pageName.equals("index.jsp")) ? "active" : ""%>"><a href="${index}">Index</a></li>
                            <li class="<%= (pageName.equals("addProduct.jsp")) ? "active" : ""%>"><a href="${add}">Add product</a></li>
                            <li class="<%=  (pageName.equals("seeProducts.jsp")) ? "active" : ""%>"><a href="${see}">List product</a></li>
                            <li class="<%=   (pageName.equals("addCategory.jsp")) ? "active" : ""%>"><a href="${addcat}">Add category</a></li>
                        </ul>
                    </div>
                </div>
            </nav>