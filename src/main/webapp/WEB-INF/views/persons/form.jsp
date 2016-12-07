<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:dashboard title="Cadastro de Pessoas" active="register">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Cadastro de Pessoas</h3>
                </div>
                <div class="panel-body">
                    <form:form method="post" servletRelativeAction="${spring:mvcUrl('PC#save').build()}"
                               commandName="person" enctype="multipart/form-data" cssClass="form">
                        <fieldset>
                            <div class="form-group">
                                <form:label path="name" class="control-label">Nome:</form:label>
                                <form:input class="form-control" type="text" path="name" onfocus="this.select();" autofocus="autofocus" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="record" class="control-label">Matricula:</form:label>
                                <form:input class="form-control" type="text" path="record" onfocus="this.select();" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="cpf" class="control-label">CPF:</form:label>
                                <form:input class="form-control" type="number" path="cpf" onfocus="this.select();" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="birthday" class="control-label">Aniversário:</form:label>
                                <form:input class="form-control" type="date" path="birthday" onfocus="this.select();" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="guardian" class="control-label">Guardião:</form:label>
                                <form:checkbox class="checkbox" path="guardian"/>
                            </div>
                            <div class="form-group">
                                <form:label path="type" class="control-label">Tipo:</form:label>
                                <form:select path="type" items="${types}" var="type"/>
                            </div>
                            <div class="form-group">
                                <form:label path="password" class="control-label">Senha:</form:label>
                                <form:input class="form-control" type="password" path="password" onfocus="this.select();" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:label path="notes" class="control-label">Observação:</form:label>
                                <form:textarea class="form-control" path="notes" onfocus="this.select();" required="required"/>
                            </div>
                            <button class="btn btn-primary" type="submit">Gravar</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</customTags:dashboard>