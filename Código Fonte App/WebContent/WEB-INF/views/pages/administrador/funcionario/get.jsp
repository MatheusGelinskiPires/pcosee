<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.funcionario.edit" /></h1>
    </div>
    <div class="col-lg-8 offset-lg-2">
        <form id="formFuncionarioGet" action="<c:out value="${pageContext.request.contextPath}"/>/administrador/funcionario/update" method="POST">
            <div class="form-row">
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.funcionario.edit" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-12" style="display: none">
                    <label for="id"><spring:message code="label.funcionario.id" /></label>
                    <input type="text" class="form-control" id="id" name="id" value="<c:out value="${funcionario.id}"/>" readonly="readonly">
                </div>
                <div class="form-group col-lg-12">
                    <label for="nome"><spring:message code="label.funcionario.nome" /></label>
                    <i id="tooltipNome" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.nome" />">help_outline</i>
                    <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${funcionario.nome}"/>">
                </div>
                <div class="form-group col-lg-12">
                    <label for="email"><spring:message code="label.funcionario.email" /></label> 
                    <i id="tooltipEmail" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.email" />">help_outline</i>
                    <input type="email" class="form-control" id="email" name="email" value="<c:out value="${funcionario.email}"/>">
                </div>
                <div class="form-group col-lg-12">
                    <label for="perfil"><spring:message code="label.funcionario.perfil" /></label>
                    <i id="tooltipPerfil" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.funcionario.dados.perfil" />">help_outline</i>
                    <select class="form-control" id="perfil" name="perfil">
                        <option value=""><spring:message code="select.option.default" /></option>
                        <option value="<c:out value="${funcionario.perfil.id}"/>" selected="selected"><c:out value="${funcionario.perfil.perfil}" /></option>
                        <c:forEach items="${listaDePerfil}" var="perfil">
                            <c:if test="${perfil.id != funcionario.perfil.id}">
                                <option value="<c:out value="${perfil.id}"/>"><c:out value="${perfil.perfil}" /></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <button type="submit" class="btn btn-primary"><spring:message code="button.atualizar" /></button>
                    <hr>
                </div>
            </div>
        </form>
    </div>
</main>