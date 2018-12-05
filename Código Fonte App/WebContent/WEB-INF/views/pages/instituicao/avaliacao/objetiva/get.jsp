<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main role="main" class="container">
    <div class="row">
        <div class="col-lg-12" style="text-align: center;">
            <h1><spring:message code="title.instituicao.avaliacao.objetiva.get" /></h1>
        </div>
        <div class="col-lg-12">
            <div class="col-lg-12" style="text-align: center;">
                <hr>
                <h4><spring:message code="subtitle.instituicao.avaliacao.objetiva.get.info" /></h4>
                <hr>
            </div>
            <div class="row" style="text-align:center">
                <div class="col-lg-6" style="text-align: center;">
                    <h5>Status</h5>
                    <p><c:out value="${gabaritoAvaliacaoObjetiva.status[fn:length(gabaritoAvaliacaoObjetiva.status)-1].status}" /></p>
                </div>
                <div class="col-lg-6" style="text-align: center;">
                    <h5>Nota</h5>
                    <p><c:out value="${gabaritoAvaliacaoObjetiva.nota}" /></p>
                </div>
            </div>
            <div class="col-lg-12 row" style="text-align: center;">
                <div class="col-lg-6" style="text-align: center;"></div>
                <div class="col-lg-6" style="text-align: center;"></div>
            </div>
            <div class="col-lg-12" style="text-align: center;">
                <hr>
                <h4><spring:message code="subtitle.instituicao.avaliacao.objetiva.get" /></h4>
                <hr>
            </div>
            <div class="col-lg-12">
                <c:forEach items="${gabaritoAvaliacaoObjetiva.gabaritoQuestaoObjetiva}"
                           var="gabaritoQuestaoObjetiva">
                    <div class="form-group">
                        <label for="gabaritoQuestaoObjetiva.questaoObjetiva.enunciado">
                            <c:out value="${gabaritoQuestaoObjetiva.questaoObjetiva.enunciado}" />
                        </label> 
                        <select class="form-control" id="gabaritoQuestaoObjetiva" name="gabaritoQuestaoObjetiva" disabled>
                            <option
                                value="<c:out value="${gabaritoQuestaoObjetiva.alternativa.id}"/>">
                                <c:out value="${gabaritoQuestaoObjetiva.alternativa.enunciado}" />
                            </option>
                        </select>
                    </div>
                </c:forEach>
            </div>
            <div class="col-lg-12" style="text-align: center;">
                <hr>
            </div>
        </div>
    </div>
</main>