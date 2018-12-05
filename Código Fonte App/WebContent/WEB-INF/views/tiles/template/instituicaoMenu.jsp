<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/">
        <spring:message code="sistema.sigla" />
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/dashboard">
                    <spring:message code="menu.dashboard" />
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/" id="dropdownInstituicoes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.dropdown.avaliacao" />
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownAvaliacao">
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva">
                        <spring:message code="menu.dropdown.avaliacao.objetiva" />
                    </a>
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa">
                        <spring:message code="menu.dropdown.avaliacao.dissertativa" />
                    </a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/sobre">
                    <spring:message code="menu.sobre" />
                </a>
            </li>
        </ul>
        <ul class="navbar-nav mr-right">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/" id="dropdownFuncionario" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <c:out value="${instituicaoLogado.representante.nome}"></c:out> - <c:out value="${instituicaoLogado.nome}"></c:out>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdowninstituicao">
                            <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/dados">
                        <spring:message code="menu.dropdown.dados" />
                    </a> 
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/logout">
                        <spring:message code="menu.dropdown.logout" />
                    </a>
                </div>
            </li>
        </ul>
    </div>
</nav>