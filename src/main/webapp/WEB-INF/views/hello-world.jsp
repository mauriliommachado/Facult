<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:page title="Home" active="home">
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal" var="user" />
        <h1>Bem vindo ${user.name}</h1> 
    </security:authorize>
</customTags:page>
