<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                <span class="navbar-brand">Livraria FIT</span>
            </div> 
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${contextPath}/FitEdu/">Home</a></li>
                    <li class="active"><a href="${contextPath}/FitEdu/grades/form">Notas <span class="sr-only">(current)</span></a></li>
                </ul>
            </div>
        </nav>
        <div name="content">
            <form:form method="post" action="${spring:mvcUrl('GC#save').build()}"
                       commandName="grade" enctype="multipart/form-data"
                       class="form-horizontal">
                <div class="form-group">
                    <label for="grade" class="control-label col-sm-2">Nota:</label>
                    <div class="col-sm-6">
                        <form:input class="form-control" path="grade"/>
                    </div>
                    <form:errors path="grade" class="alert alert-danger"/>
                </div>
                <div class="col-sm-offset-2 ">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </form:form>
        </div>
    </body>
</html>
