<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.meus.dados" /></h1>
    </div>
    <div class="col-lg-8 offset-lg-2">
        <form id="formAdministradorDados" action="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/dados/update" method="POST">
            <div class="form-row">
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.meus.dados" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-12" style="display: none">
                    <label for="id"><spring:message code="label.funcionario.id" /></label>
                    <input type="text" class="form-control" id="id" name="id" value="<c:out value="${funcionarioLogado.id}"/>" readonly="readonly">
                </div>
                <div class="form-group col-lg-12">
                    <label for="nome"><spring:message code="label.funcionario.nome" /></label>
                    <i id="tooltipNome" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.dados.nome" />">help_outline</i>
                    <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${funcionarioLogado.nome}"/>">
                </div>
                <div class="form-group col-lg-12">
                    <label for="email"><spring:message code="label.funcionario.email" /></label>
                    <i id="tooltipEmail" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.dados.email" />">help_outline</i>
                    <input type="email" class="form-control" id="email" name="email" value="<c:out value="${funcionarioLogado.email}"/>">
                </div>
                <div class="form-group col-lg-12">
                    <label for="perfil"><spring:message code="label.funcionario.perfil" /></label>
                    <i id="tooltipPerfil" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.administrador.dados.perfil" />">help_outline</i>
                    <select class="form-control disable" id="perfil" name="perfil">
                        <option value="<c:out value="${funcionarioLogado.perfil.id}"/>" selected="selected"><c:out value="${funcionarioLogado.perfil.perfil}" /></option>
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