<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:if test="${funcionarioLogado == null}">
    <c:redirect url="/logout"></c:redirect>
</c:if>
<c:if test="${funcionarioLogado.perfil.perfil != 'Administrador' }">
    <c:redirect url="/logout"></c:redirect>
</c:if>
<html>
    <head>
        <tiles:insertAttribute name="head" />
        <tiles:insertAttribute name="scripts" />
    </head>
    <body class="bodyportal">
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
    </body>
</html>