<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:dashboard title="Cadastro de Notas" active="register">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Cadastro de Notas</h3>
                </div>
                <div class="panel-body">
                    <form:form method="post" servletRelativeAction="${spring:mvcUrl('GC#save').build()}"
                               commandName="grade" enctype="multipart/form-data" cssClass="form">
                        <fieldset>
                            <form:label path="grade" class="control-label">Nota:</form:label>
                                <div class="form-group">
                                <form:input required="required" class="form-control" type="number" path="grade" onfocus="this.select();" autofocus="autofocus"/>
                            </div>
                            <button class="btn btn-primary" type="submit">Gravar</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</customTags:dashboard>