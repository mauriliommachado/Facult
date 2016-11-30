<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="pt"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="pt"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="pt"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="pt">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, maximum-scale=1">

        <title>${product.title}</title>
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
        <article id="${product.title}" itemscope
                 itemtype="http://schema.org/Book">
            <header id="product-highlight" class="clearfix">
                <div id="product-overview" class="container">
                    <h1 class="product-title" itemprop="name">${product.title}</h1>

                    <p itemprop="description" class="book-description">
                        ${product.description}
                        <br><br>
                    <div class="container">
                        <section class="data product-detail">
                            <h2 class="section-title">Dados do livro:</h2>
                            <p>
                                Número de paginas: <span itemprop="numberOfPages">${product.pages}</span>
                            </p>
                            <p></p>
                            <p>
                                Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta
                                    uma errata</a>
                            </p>
                        </section>
                    </div><br>

                    Veja o <a
                        href="<c:url value='/${product.summaryPath}'/>"
                        target="_blank">sum&#225;rio</a> completo do livro!
                    </p>
                </div>
            </header>
            <section class="buy-options clearfix">
                <form action="<c:url value="/shopping"/>" method="post" class="container">
                    <input type="hidden" value="${product.id}" name="productId"/>
                    <ul id="variants" class="clearfix">
                        <c:forEach items="${product.prices}" var="price">
                            <li class="buy-option">

                                <input type="radio"
                                       name="bookType" class="variant-radio" id="${product.id}-${price.bookType}"
                                       value="${price.bookType}" ${price.bookType.name() == 'COMBO' ? 'checked' : ''}>

                                <label  class="variant-label" for="${product.id}-${price.bookType}"> 
                                    ${price.bookType} - R$ ${price.value}							
                                </label> 
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="submit" class="submit-image icon-basket-alt"
                           alt="Compre agora"
                           title="Compre agora '${product.title}'!" value="comprar"/>
                </form>
            </section>
        </article>
    </body>
</html>