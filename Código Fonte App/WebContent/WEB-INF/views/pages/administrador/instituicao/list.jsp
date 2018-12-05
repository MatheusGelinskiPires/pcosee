<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.instituicao.list" />
            <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/add">
                <i class="material-icons md-24" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.instituicao.nova" />">add_circle</i>
            </a>
        </h1>
    </div>
    <hr>
    <div>
        <table id="tabelaDeInstituicao" class="display" cellspacing="0"
               width="100%">
            <thead>
                <tr>
                    <th><spring:message code="table.administrador.instituicao.nome" /></th>
                    <th><spring:message code="table.administrador.instituicao.email" /></th>
                    <th><spring:message code="table.administrador.instituicao.administracao" /></th>
                    <th><spring:message code="table.administrador.instituicao.acao" /></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaDeInstituicao}" var="instituicao">
                    <tr>
                        <td><c:out value="${instituicao.nome}" /></td>
                        <td><c:out value="${instituicao.email}" /></td>
                        <td><c:out value="${instituicao.administracao.administracao}" /></td>
                        <td>
                            <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/get/<c:out value="${instituicao.id}"/>">
                                <i class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.instituicao.editar" />">search</i>
                            </a>
                            <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/delete/<c:out value="${instituicao.id}"/>">
                                <i class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.instituicao.excluir" />">delete</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>