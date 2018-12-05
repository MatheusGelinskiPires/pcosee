<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<c:out value="${pageContext.request.contextPath}"></c:out>"><spring:message code="sistema.sigla"/></a>
    <ul class="navbar-nav mr-right">
        <li class="nav-item">
            <a class="nav-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/sobre"><spring:message code="menu.sobre"/></a>
        </li>
    </ul>
</nav>