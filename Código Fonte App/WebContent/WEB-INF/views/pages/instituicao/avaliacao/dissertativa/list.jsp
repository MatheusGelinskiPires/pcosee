<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.instituicao.avaliacao.dissertativa.list" /></h1>
    </div>
    <div class="col-lg-12">
        <div class="col-lg-12" style="text-align: center;">
            <hr>
            <h4><spring:message code="subtitle.instituicao.avaliacao.dissertativa.list" /></h4>
            <hr>
        </div>
        <div class="col-lg-10 offset-lg-1" style="text-align: center;">
            <table id="tabelaDeGabaritoAvaliacaoDissertativa" class="display" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th><spring:message code="table.auditor.avaliacao.dissertativa.periodo" /></th>
                        <th><spring:message code="table.auditor.avaliacao.dissertativa.status" /></th>
                        <th><spring:message code="table.auditor.avaliacao.dissertativa.nota" /></th>
                        <th><spring:message code="table.auditor.avaliacao.dissertativa.acao" /></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaDeGabaritoAvaliacaoDissertativa}" var="gabaritoAvaliacaoDissertativa">
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Pendente'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/add/<c:out value="${gabaritoAvaliacaoDissertativa.periodo.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.pendente.responder" />">create</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.objetiva.pendente" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Aguardando Auditoria'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/get/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.aguardando.auditoria" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Não Participou'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.nao.participou" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Respondida'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/get/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.respondida" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Aguardando Classificação'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/get/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.aguardando.classificacao" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Finalizada'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/get/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.finalizada" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                            <c:if test="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status == 'Classificada'}">
                            <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.inicioSegundaFase}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${gabaritoAvaliacaoDissertativa.periodo.fim}"/></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></td>
                                <td><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></td>
                                <td>
                                    <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/get/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>">
                                        <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.visualizar" />">search</i>
                                    </a>
                                    <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.classificada" />">info</i>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-12">
            <hr>
        </div>
    </div>
</main>