<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/">
        <spring:message code="sistema.sigla" />
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/dashboard">
                    <spring:message code="menu.dashboard" />
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/periodo/" id="dropdownAvaliacoes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.dropdown.avaliacao" />
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownAvaliacoes">
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/periodo/list">
                        <spring:message code="menu.dropdown.periodo" />
                    </a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/" id="dropdownInstituicoes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.dropdown.instituicao" />
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownInstituicoes">
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/add">
                        <spring:message code="menu.dropdown.instituicao.adicionar" />
                    </a>
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/list">
                        <spring:message code="menu.dropdown.instituicao.listar" />
                    </a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/" id="dropdownFuncionarios" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="menu.dropdown.funcionario" />
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownFuncionarios">
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/add">
                        <spring:message code="menu.dropdown.funcionario.adicionar" />
                    </a>
                    <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/list">
                        <spring:message code="menu.dropdown.funcionario.listar" />
                    </a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/sobre">
                    <spring:message code="menu.sobre" />
                </a>
            </li>
        </ul>
        <ul class="navbar-nav mr-right">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/" id="dropdownFuncionario" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <c:out value="${funcionarioLogado.nome}"></c:out>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownFuncionario">
                        <a class="dropdown-item" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/dados">
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