<%-- 
    Document   : navbar
    Created on : 05/12/2016, 22:10:26
    Author     : mauri
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<nav class="navbar navbar-inverse">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <span class="navbar-brand">Dashboard</span>
    </div> 
    <security:authentication property="principal" var="user" />
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li id="home"><a href="${contextPath}/FitEdu/dashboard">Dashboard <span class="sr-only">(current)</span></a></li>
            <li class="dropdown">
                <a href="" id="register" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li ><a href="${contextPath}/FitEdu/grades">Notas</a></li>
                    <li><a href="${contextPath}/FitEdu/persons">Pessoas</a></li>
                    <li><a href="#">Turmas</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Cursos</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <security:authorize access="isAuthenticated()">
                <li><a href="${contextPath}/FitEdu/logout"><span class="glyphicon glyphicon-user"> Logout</span></a></li>
            </security:authorize>
        </ul>
    </div>
</nav>
