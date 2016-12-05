<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <span class="navbar-brand">Facult</span>
            </div> 
            <security:authentication property="principal" var="user" />
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${contextPath}/FitEdu/">Home <span class="sr-only">(current)</span></a></li>
                        <security:authorize access="isAuthenticated()">
                        <li><a href="${contextPath}/FitEdu/grades">Notas</a></li>
                        </security:authorize>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <security:authorize access="isAuthenticated()">
                        <li><a href="${contextPath}/FitEdu/logout"><span class="glyphicon glyphicon-user"> Logout</span></a></li>
                        </security:authorize>
                        <security:authorize access="isAnonymous()">
                        <li><a href="${contextPath}/FitEdu/auth/login"><span class="glyphicon glyphicon-user"> Login</span></a></li>
                        </security:authorize>
                </ul>
            </div>
        </nav>
        <div name="content">
            <security:authorize access="isAuthenticated()">
                <security:authentication property="principal" var="user" />
                <h1>Bem vindo ${user.name}</h1> 
            </security:authorize>
        </div>
    </body>
</html>
