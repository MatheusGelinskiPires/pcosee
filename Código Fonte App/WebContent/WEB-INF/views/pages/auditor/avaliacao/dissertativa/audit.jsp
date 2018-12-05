<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main role="main" class="container">
    <div class="row">
        <div class="col-lg-12" style="text-align: center;">
            <h1><spring:message code="title.auditor.avaliacao.dissertativa.auditoria" /></h1>
        </div>
        <div class="col-lg-12">
            <div class="col-lg-12" style="text-align: center;">
                <hr>
                <h4><spring:message code="subtitle.auditor.avaliacao.dissertativa.auditoria" /></h4>
                <hr>
            </div>
            <div class="col-lg-12">
                <form id="formAuditDis" action="<c:out value="${pageContext.request.contextPath}"></c:out>/auditor/avaliacao/dissertativa/audit/<c:out value="${gabaritoAvaliacaoDissertativa.id}"/>" method="POST">
                    <c:forEach items="${gabaritoAvaliacaoDissertativa.gabaritoQuestaoDissertativa}" var="gabaritoQuestaoDissertativa">
                        <div class="form-group">
                            <label for="resposta.<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>">
                                <c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.enunciado}" />
                            </label>
                            <textarea class="form-control" id="resposta.<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" name="resposta.<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" disabled><c:out value="${gabaritoQuestaoDissertativa.resposta}"/></textarea>
                        </div>
                        <div class="form-group">
                            <label for="<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>">
                                <spring:message code="label.avaliacao.dissertativa.nota" />
                            </label>
                                <select class="form-control" id="<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" name="<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" required>
                                <option value="" selected>
                                    <spring:message code="select.option.default" />
                                </option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                    </c:forEach>
                    <div class="form-group">
                        <label for="gabaritoQuestaoDissertativa.documento">Documento de Comprovação de Veracidade</label>
                        <a href="<c:out value="${pageContext.request.contextPath}"></c:out>/auditor/avaliacao/dissertativa/docviewer/<c:out value="${gabaritoAvaliacaoDissertativa.id}"></c:out>" style="text-decoration: none; color: black;">
                            <i id="tooltipRepresentanteDocumentoVisualizar" class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.auditor.avaliacao.dissertativa.documento.de.veracidade.visualizar" />">insert_photo</i>
                        </a>
                        <input type="text" class="form-control" id="gabaritoAvaliacaoDissertativa.documento.nome" name="gabaritoAvaliacaoDissertativa.documento.nome" value="<c:out value="${gabaritoAvaliacaoDissertativa.documento.nome}"/>" readonly disabled />
                    </div>
                    <button type="submit" class="btn btn-primary"><spring:message code="button.auditar" /></button>
                </form>
            </div>
            <div class="col-lg-12" style="text-align: center;">
                <hr>
            </div>
        </div>
    </div>
</main>