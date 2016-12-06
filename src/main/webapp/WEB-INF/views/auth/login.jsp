<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:page title="Home" active="login">
    <form:form cssClass="form-horizontal" servletRelativeAction="/login">
        <div class="form-group">
            <label for="username" class="control-label col-sm-2">Usuário</label>
            <div class="col-sm-6">
                <input class="form-control" name="username"/>
            </div>
            <form:errors path="username" class="alert alert-danger"/>
        </div>
        <div class="form-group">
            <label for="password" class="control-label col-sm-2">Senha:</label>
            <div class="col-sm-6">
                <input class="form-control" name="password"/>
            </div>
            <form:errors path="password" class="alert alert-danger"/>
        </div>
        <div class="col-sm-offset-2 ">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form:form>
</customTags:page>
