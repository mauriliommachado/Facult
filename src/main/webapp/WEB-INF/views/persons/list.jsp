<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de produtos</title>
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
            <h2>${sucesso}</h2>
            <div class="panel panel-default">
            <div class="panel-heading">Produtos</div>
            <table class="table">
                 <tr>
                     <td>Titulo</td>
                    <td>Valores</td>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td><a href="${spring:mvcUrl('PC#show').arg(0,product.id).build()}">${product.title}</a></td>
                        <td>
                            <c:forEach items="${product.prices}" var="price">
                                [${price.value}-${price.bookType}]
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
            <br>
            <a href="${contextPath}/Livraria/produtos/form"
                    class="btn btn-default" 
                    aria-label="Left Align">Adicionar novo</a>
        </div>
    </body>
</html>
