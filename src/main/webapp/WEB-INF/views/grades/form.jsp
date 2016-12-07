<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:dashboard title="Home" active="register">
    <form:form method="post" servletRelativeAction="${spring:mvcUrl('GC#save').build()}"
               commandName="grade" enctype="multipart/form-data"
               cssClass="form-horizontal">
        <div class="form-group">
            <label for="grade" class="control-label col-sm-2">Nota:</label>
            <div class="col-sm-6">
                <form:input class="form-control" type="number" path="grade"/>
            </div>
            <form:errors path="grade" class="alert alert-danger"/>
        </div>
        <div class="col-sm-offset-2 ">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form:form>
</customTags:dashboard>