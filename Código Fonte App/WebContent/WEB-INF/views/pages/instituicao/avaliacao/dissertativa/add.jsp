<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.instituicao.avaliacao.dissertativa.add" /></h1>
    </div>
    <hr>
    <div>
        <form id="formGabaritoAvaliacaoDissertativa" action="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa/add" method="POST" enctype="multipart/form-data">
            <input type="text" name="periodo" id="periodo" value="<c:out value="${periodo.id}"/>" hidden="true">
            <c:forEach items="${avaliacaoDissertativa.questaoDissertativa}" var="questaoDissertativa">
                <div class="form-group">
                    <label for="<c:out value="${questaoDissertativa.id}"/>"><c:out value="${questaoDissertativa.enunciado}" /></label>
                    <textarea class="form-control required" id="<c:out value="${questaoDissertativa.id}"/>" name="<c:out value="${questaoDissertativa.id}"/>" required></textarea>
                </div>
            </c:forEach>
            <div class="form-group">
                <label for="doc"><spring:message code="subtitle.instituicao.avaliacao.dissertativa.add.documento" /></label> 
                <i id="tooltipQuestaoDissertativaDocumento" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.avaliacao.dissertativa.documento.de.veracidade" />">help_outline</i>
                <input type="file" class="form-control required" id="doc" name="doc" accept="pdf">
            </div>
            <button type="submit" class="btn btn-primary"><spring:message code="button.responder" /></button>
        </form>
    </div>
    <hr>
</main>