<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.instituicao.avaliacao.objetiva.list" /></h1>
    </div>
    <div class="col-lg-12">
        <div class="col-lg-12" style="text-align: center;">
            <hr>
            <h4><spring:message code="subtitle.instituicao.avaliacao.objetiva.list" /></h4>
            <hr>
        </div>
        <div class="col-lg-10 offset-lg-1" style="text-align: center;">
            <table id="tabelaDeGabaritoAvaliacaoObjetiva" class="display" cellspacing="0"
                   width="100%">
                <thead>
                    <tr>
                        <th><spring:message code="table.auditor.avaliacao.objetiva.periodo" /></th>
                        <th><spring:message code="table.auditor.avaliacao.objetiva.status" /></th>
                        <th><spring:message code="table.auditor.avaliacao.objetiva.nota" /></th>
                        <th><spring:message code="table.auditor.avaliacao.objetiva.acao" /></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaDeGabaritoAvaliacaoObjetiva}" var="gabaritoAvaliacaoObjetiva">
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Pendente'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva/add/<c:out value="${gabaritoAvaliacaoObjetiva.periodo.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.pendente.responder" />">create</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.pendente" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Não Iniciado'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.nao.iniciado" /> <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/>.">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Não Participou'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.nao.participou" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Respondida'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva/get/<c:out value="${gabaritoAvaliacaoObjetiva.id}"/>">
                                        <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.respondida" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Concluída'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva/get/<c:out value="${gabaritoAvaliacaoObjetiva.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.concluida" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status == 'Classificada'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioPrimeiraFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoObjetiva.periodo.inicioSegundaFase}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva/get/<c:out value="${gabaritoAvaliacaoObjetiva.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.classificada" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-12" style="text-align: center;">
            <hr>
        </div>
    </div>
</main>