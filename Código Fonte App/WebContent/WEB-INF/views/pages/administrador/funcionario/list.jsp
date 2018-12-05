<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.funcionario"/>
            <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/add">
                <i class="material-icons md-24" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.novo" />">add_circle</i>
            </a>
        </h1>
    </div>
    <div class="col-lg-12">
        <div class="col-lg-12" style="text-align: center;">
            <hr>
            <h4><spring:message code="subtitle.administrador.funcionario"/></h4>
            <hr>
        </div>
        <table id="tabelaDeFuncionario" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th><spring:message code="table.administrador.funcionario.nome"/></th>
                    <th><spring:message code="table.administrador.funcionario.email"/></th>
                    <th><spring:message code="table.administrador.funcionario.perfil"/></th>
                    <th><spring:message code="table.administrador.funcionario.acao"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaDeFuncionario}" var="funcionario">
                    <c:if test="${funcionario.id != funcionarioLogado.id}">
                        <tr>
                            <td><c:out value="${funcionario.nome}" /></td>
                            <td><c:out value="${funcionario.email}" /></td>
                            <td><c:out value="${funcionario.perfil.perfil}" /></td>
                            <td>
                                <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/get/<c:out value="${funcionario.id}"/>">
                                    <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.editar" />">search</i>
                                </a> 
                                <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/delete/<c:out value="${funcionario.id}"/>">
                                    <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.excluir" />">delete</i>
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
        <div class="col-lg-12" style="text-align: center;">
            <hr>
        </div>
    </div>
</main>