<%-- 
    Document   : dashboard
    Created on : Apr 25, 2017, 11:07:58 AM
    Author     : BioTI
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="autenticacao_header.jsp" %>
            <h1>Voce esta no dashboard!</h1>
            
            <span sec:authentication="name"></span>
            <h3>Menu</h3>
            <ul>
                <security:authorize access="hasAnyRole('ROLE_GERENCIA')">    
                    <li><a href="<c:url value='/dashboard' />">GERENCIA</a></li>
                </security:authorize>
                <security:authorize access="hasAnyRole('ADMIN')">    
                    <li><a href="<c:url value='/configuracao' />">Configuracao</a></li>
                </security:authorize>

            </ul>
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                    <div class="col-md-7">
                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="userProfiles" class="help-inline"/>
                        </div>
                    </div>
                </div>

        </div>

    </body>
</html>
