<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.instituicao.avaliacao.objetiva.add" /></h1>
    </div>
    <hr>
    <div>
        <form:form action="${pageContext.request.contextPath}/instituicao/avaliacao/objetiva/add" method="POST" modelAttribute="GabaritoAvaliacaoObjetiva" >
            <input type="text" name="periodo" id="periodo" value="<c:out value="${periodo.id}"/>" hidden="true">
            <c:forEach items="${avaliacaoObjetiva.questaoObjetiva}" var="questaoObjetiva">
                <div class="form-group">
                    <label for="avaliacaoObjetiva.questaoObjetiva"><c:out value="${questaoObjetiva.enunciado}" /></label>
                    <select class="form-control" id="questaoObjetiva" name="questaoObjetiva">
                        <option value="" selected>
                            <spring:message code="select.option.default" />
                        </option>
                        <c:forEach items="${questaoObjetiva.alternativa}" var="alternativa">
                            <option value="<c:out value="${questaoObjetiva.id};${alternativa.id}"/>">
                                <c:out value="${alternativa.enunciado}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-primary"><spring:message code="button.responder" /></button>
        </form:form>
    </div>
    <hr>
</main>