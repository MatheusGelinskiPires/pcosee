<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.funcionario.add" /></h1>
    </div>
    <div class="col-lg-8 offset-lg-2">
        <form id="formFuncionarioAdd" action="<c:out value="${pageContext.request.contextPath}"/>/administrador/funcionario/add" method="POST">
            <div class="form-row">
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.funcionario.add" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-12">
                    <label for="nome"><spring:message code="label.funcionario.nome" /></label>
                    <i id="tooltipNome" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.nome" />">help_outline</i>
                    <input type="text" class="form-control" id="nome" name="nome">
                </div>
                <div class="form-group col-lg-12">
                    <label for="email"><spring:message code="label.funcionario.email" /></label>
                    <i id="tooltipEmail"  class="tooltiphelper material-icons md-18"data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.email" />">help_outline</i>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="form-group col-lg-12">
                    <label for="perfil"><spring:message code="label.funcionario.perfil" /></label>
                    <i id="tooltipPerfil"  class="tooltiphelper material-icons md-18"data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.perfil" />">help_outline</i>
                    <select class="form-control" id="perfil" name="perfil">
                        <option value="" selected>Selecione</option>
                        <c:forEach items="${listaDePerfil}" var="perfil">
                            <option value="<c:out value="${perfil.id}"/>"><c:out value="${perfil.perfil}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <button type="submit" class="btn btn-primary"><spring:message code="button.cadastrar" /></button>
                    <hr>
                </div>
            </div>
        </form>
    </div>
</main>