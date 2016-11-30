<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
                    <li><a href="${contextPath}/Livraria/produtos/">Produtos</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="${spring:mvcUrl('SCC#items').build()}" rel="nofollow"><span class="glyphicon glyphicon-shopping-cart"></span><span class="badge">${shoppingCart.quantity}</span> <span class="sr-only">(current)</span></a></li>
                </ul>
            </div>
        </nav>
        <section class="container middle">

            <h2 id="cart-title">Seu carrinho de compras</h2>

            <table id="cart-table">
                <colgroup>
                    <col class="item-col">
                    <col class="item-price-col">
                    <col class="item-quantity-col">
                    <col class="line-price-col">
                    <col class="delete-col">
                </colgroup>
                <thead>
                    <tr>
                        <th class="cart-img-col"></th>
                        <th width="65%">Item</th>
                        <th width="10%">Preço</th>
                        <th width="10%">Quantidade</th>
                        <th width="10%">Total</th>
                        <th width="5%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${shoppingCart.list}" var="item">
                        <tr>
                            <td class="cart-img-col"><img src="" alt="${item.product.title}"/></td><td class="item-title">${item.product.title} - ${item.bookType}</td>
                            <td class="numeric-cell">${item.price}</td>
                            <td class="quantity-input-cell"><input type="number" min="0" readonly="readonly" value="${shoppingCart.getQuantity(item)}"></td>
                            <td class="numeric-cell">${shoppingCart.getTotal(item)}</td>
                            <td class="remove-item"><form method="post" action="${spring:mvcUrl('SCC#remove').arg(0,item.product.id).arg(1,item.bookType).build()}"><input type="image" src="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/excluir.png?58522" alt="Excluir" title="Excluir" /></form></td>
                        </tr>
                    </c:forEach>

                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2"><input type="submit" class="checkout" name="checkout" value="Finalizar compra " id="checkout"/></td>
                        <td class="numeric-cell">${shoppingCart.total}</td><td></td>
                    </tr>
                </tfoot>
            </table>
        </section> 

    </body>
</html>