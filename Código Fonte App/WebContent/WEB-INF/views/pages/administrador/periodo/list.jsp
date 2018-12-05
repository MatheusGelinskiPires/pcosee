<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:useBean id="now" class="java.util.Date"/>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.periodo" /></h1>
    </div>
    <div class="col-lg-8 offset-lg-2">
        <form id="formPeriodoAdd" action="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/periodo/add" method="POST">
            <div class="form-row">
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="title.administrador.periodo.add" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-12">
                    <label for="inicioPrimeiraFase"><spring:message code="label.periodo.inicio.primeira.fase" /></label>
                    <i id="tooltipInicioPrimeiraFase" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.periodo.inicio.primeira.fase" />">help_outline</i>
                    <input type="date" class="form-control" id="inicioPrimeiraFase" name="inicioPrimeiraFase" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                </div>
                <div class="form-group col-lg-12">
                    <label for="inicioSegundaFase"><spring:message code="label.periodo.inicio.segunda.fase" /></label>
                    <i id="tooltipInicioSegundaFase" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.periodo.inicio.segunda.fase" />">help_outline</i>
                    <input type="date" class="form-control" id="inicioSegundaFase" name="inicioSegundaFase" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                </div>
                <div class="form-group col-lg-12">
                    <label for="fim"><spring:message code="label.periodo.fim" /></label>
                    <i id="tooltipFim" class=" tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.periodo.fim" />">help_outline</i>
                    <input type="date" class="form-control" id="fim" name="fim" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <button type="submit" class="btn btn-primary"><spring:message code="button.cadastrar" /></button>
                    <hr>
                </div>
            </div>
        </form>
    </div>
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.periodo.list" /></h1>
    </div>
    <div class="col-lg-12">
        <div class="col-lg-12" style="text-align: center;">
            <hr>
        </div>
        <table id="tabelaDePeriodo" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th style="text-align: center;"><spring:message code="table.administrador.periodo.inicio.primeira.fase" /></th>
                    <th style="text-align: center;"><spring:message code="table.administrador.periodo.inicio.segunda.fase" /></th>
                    <th style="text-align: center;"><spring:message code="table.administrador.periodo.fim" /></th>
                    <th style="text-align: center;"><spring:message code="table.administrador.periodo.acao" /></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaDePeriodo}" var="periodo">	
                    <tr>
                        <td style="text-align: center;"><fmt:formatDate pattern="dd/MM/yyyy" value="${periodo.inicioPrimeiraFase}"/></td>
                        <td style="text-align: center;"><fmt:formatDate pattern="dd/MM/yyyy" value="${periodo.inicioSegundaFase}" /></td>
                        <td style="text-align: center;"><fmt:formatDate pattern="dd/MM/yyyy" value="${periodo.fim}" /></td>
                        <td style="text-align: center;">
                            <c:if test="${now le periodo.inicioPrimeiraFase}">
                                <a class="linkcustom" href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/periodo/delete/<c:out value="${periodo.id}"/>">
                                    <i class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.periodo.excluir" />">delete</i>
                                </a>
                            </c:if>
                            <c:if test="${now ge periodo.inicioPrimeiraFase}">
                                <i class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.periodo.info" />">info</i>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="col-lg-12" style="text-align: center;">
            <hr>
        </div>
    </div>
</main>