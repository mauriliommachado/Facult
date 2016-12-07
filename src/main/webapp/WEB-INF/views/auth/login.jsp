<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:page title="Login" active="login">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>
                <div class="panel-body">
                    <form:form cssClass="form" servletRelativeAction="/login">
                        <fieldset>
                             <div class="form-group">
                                    <input class="form-control" placeholder="Id" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
<!--                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Lembrar
                                </label>
                            </div>-->
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</customTags:page>

