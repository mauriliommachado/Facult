<%@attribute name="title" required="true" %>
<%@attribute name="active" required="true" %>
<%@attribute name="extraScripts" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="pt"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="pt"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="pt"><![endif]-->
<!--[if gt IE 8]><!-->
<html>
    <head>
        <security:authentication property="principal" var="user" />
        <%@include file="/WEB-INF/headDashboard.jsp" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, maximum-scale=1">
        <script>
            $(document).ready(function (){
                $("#${active}").addClass("active");
            });
        </script>
        <title>${title}</title>
    </head>
    <body>
        <%@include file="/WEB-INF/navbarDashBoard.jsp"%>
        <div name="content">
            <jsp:doBody/>
        </div>
    </body>
</html>
<jsp:invoke fragment="extraScripts"/>