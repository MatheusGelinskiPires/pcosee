<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main role="main" class="container">
    <div class="row">
        <div class="col-lg-12" style="text-align: center;">
            <h1><spring:message code="title.instituicao.avaliacao.dissertativa.get" /></h1>
        </div>
        <div class="col-lg-12">
            <div class="col-lg-12" style="text-align: center;">
                <hr>
                <h4><spring:message code="subtitle.instituicao.avaliacao.dissertativa.get.info" /></h4>
                <hr>
            </div>
            <div class="row" style="text-align:center">
                <div class="col-lg-6" style="text-align: center;">
                    <h5>Status</h5>
                    <p><c:out value="${gabaritoAvaliacaoDissertativa.status[fn:length(gabaritoAvaliacaoDissertativa.status)-1].status}" /></p>
                </div>
                <div class="col-lg-6" style="text-align: center;">
                    <h5>Nota</h5>
                    <p><c:out value="${gabaritoAvaliacaoDissertativa.nota}" /></p>
                </div>
            </div>
            <div class="col-lg-12" style="text-align: center;">
                <hr>
                <h4><spring:message code="subtitle.instituicao.avaliacao.dissertativa.get" /></h4>
                <hr>
            </div>
            <div class="col-lg-12">
                <c:forEach items="${gabaritoAvaliacaoDissertativa.gabaritoQuestaoDissertativa}"
                           var="gabaritoQuestaoDissertativa">
                    <div class="form-group">
                        <label for="gabaritoQuestaoDissertativa.questaoDissertativa.enunciado">
                            <c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.enunciado}" />
                        </label>
                        <textarea class="form-control" id="<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" name="<c:out value="${gabaritoQuestaoDissertativa.questaoDissertativa.id}"/>" disabled><c:out value="${gabaritoQuestaoDissertativa.resposta}"/></textarea>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <label for="gabaritoQuestaoDissertativa.documento">Documento de Comprovação de Veracidade</label>
                    <a href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/docviewer/<c:out value="${gabaritoAvaliacaoDissertativa.id}"></c:out>" class="linkcustom">
                        <i id="tooltipRepresentanteDocumentoVisualizar" class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.auditor.avaliacao.dissertativa.documento.de.veracidade.visualizar" />">insert_photo</i>
                    </a>
                    <input type="text" class="form-control" id="gabaritoAvaliacaoDissertativa.documento.nome" name="gabaritoAvaliacaoDissertativa.documento.nome" value="<c:out value="${gabaritoAvaliacaoDissertativa.documento.nome}"/>" readonly disabled />
                </div>
            </div>
            <div class="col-lg-12">
                <hr>
            </div>
        </div>
    </div>
</main>