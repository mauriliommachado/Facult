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
        <span class="navbar-brand">Facult</span>
    </div> 
    <security:authentication property="principal" var="user" />
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li id="home"><a href="${contextPath}/FitEdu/">Home <span class="sr-only">(current)</span></a></li>
            <security:authorize access="isAuthenticated()">
                <li id="grades"><a href="${contextPath}/FitEdu/grades">Notas</a></li>
            </security:authorize>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <security:authorize access="isAuthenticated()">
                <li><a href="${contextPath}/FitEdu/logout"><span class="glyphicon glyphicon-user"> Logout</span></a></li>
            </security:authorize>
            <security:authorize access="isAnonymous()">
                <li id="login"><a href="${contextPath}/FitEdu/auth/login"><span class="glyphicon glyphicon-user"> Login</span></a></li>
            </security:authorize>
        </ul>
    </div>
</nav>
