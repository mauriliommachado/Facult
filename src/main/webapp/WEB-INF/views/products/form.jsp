<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Produtos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                </button>
                <span class="navbar-brand">Livraria FIT</span>
            </div> 
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${contextPath}/Livraria/">Home</a></li>
                    <li class="active"><a href="${contextPath}/Livraria/produtos/">Produtos <span class="sr-only">(current)</span></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${spring:mvcUrl('SCC#items').build()}" rel="nofollow"><span class="glyphicon glyphicon-shopping-cart"></span><span class="badge">${shoppingCart.quantity}</span></a></li>
                </ul>
            </div>
        </nav>

        <div name="content">
            <form:form method="post" action="${spring:mvcUrl('PC#save').build()}"
                       commandName="product" enctype="multipart/form-data"
                       class="form-horizontal">
                <div class="form-group">
                    <label for="title" class="control-label col-sm-2">Titulo:</label>
                    <div class="col-sm-6">
                        <form:input  class="form-control" path="title"/>
                    </div>
                    <form:errors path="title" class="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="description" class="control-label col-sm-2">Descrição:</label>
                    <div class="col-sm-6">
                        <form:textarea class="form-control" rows="10" cols="20" path="description"></form:textarea>
                        </div>
                    <form:errors path="description" class="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="pages" class="control-label col-sm-2">Número de paginas:</label>
                    <div class="col-sm-6">
                        <form:input class="form-control" path="pages"/>
                    </div>
                    <form:errors path="pages" class="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="releaseDate" class="control-label col-sm-2">Data:</label>
                    <div class="col-sm-6">
                        <form:input class="form-control" type="date" path="releaseDate"/>
                    </div>
                    <form:errors path="releaseDate" class="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="summary" class="control-label col-sm-2">Sumário:</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="file" path="summary" name="summary"/>
                    </div>
                    <form:errors path="summaryPath" class="alert alert-danger"/>
                </div>
                <c:forEach items="${types}" var="bookType" varStatus="status">
                    <div class="form-group">
                        <label for="preco_${bookType}" class="control-label col-sm-2">${bookType}:</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" path="prices[${status.index}].value" id="preco_${bookType}"/>
                        </div>
                        <form:input type="hidden" path="prices[${status.index}].bookType" value="${bookType}"/>
                    </div>
                </c:forEach>
                <div class="col-sm-offset-2 ">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </form:form>
        </div>

    </body>
</html>

