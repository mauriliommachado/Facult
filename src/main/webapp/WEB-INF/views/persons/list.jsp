<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:dashboard title="Lista de Pessoas" active="register">
    <h2>${sucesso}</h2>
    <div class="panel panel-default" style="margin: 10px;padding: 10px">
        <div class="table-responsive">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td style="width: 60px">Deletar</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${persons}" var="person">
                        <tr>
                            <td>${person.name}</td>
                            <td class="remove-item">
                                <form:form method="post"
                                           action="${spring:mvcUrl('PC#remove').arg(0,person.id).build()}">
                                    <button type="submit" class="btn btn-danger">Deletar</button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
        <br>
        <a href="${contextPath}/FitEdu/persons/form"
           class="btn btn-default" 
           aria-label="Left Align">Adicionar novo</a>
    </div>

</customTags:dashboard>
