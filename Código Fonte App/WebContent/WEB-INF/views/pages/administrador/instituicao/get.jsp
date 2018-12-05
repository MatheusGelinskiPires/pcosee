<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.instituicao.edit" /></h1>
    </div>
    <div class="col-lg-10 offset-lg-1">
        <form id="formInstituicaoGet" action="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/update" method="POST" enctype="multipart/form-data">
            <div class="form-row">
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.instituicao.edit" /></h4>
                    <hr>
                </div>
                <div class="form-group" style="display: none">
                    <label for="id"><spring:message code="label.instituicao.id" /></label>
                    <input type="text" class="form-control" id="id" name="id" value="<c:out value="${instituicao.id}"/>" readonly="readonly">
                </div>
                <div class="form-group col-lg-6">
                    <label for="nome"><spring:message code="label.instituicao.nome" /></label>
                    <i id="tooltipNome" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.nome" />">help_outline</i>
                    <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${instituicao.nome}"/>" required>
                </div>
                <div class="form-group col-lg-6">
                    <label for="cnpj"><spring:message code="label.instituicao.cnpj" /></label>
                    <i id="tooltipCNPJ" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.cnpj" />">help_outline</i>
                    <input type="text" class="form-control cnpj" id="cnpj" name="cnpj" value="<c:out value="${instituicao.cnpj}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="email"><spring:message code="label.instituicao.email" /></label>
                    <i id="tooltipEmail" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.email" />">help_outline</i>
                    <input type="email" class="form-control" id="email" name="email" value="<c:out value="${instituicao.email}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="site"><spring:message code="label.instituicao.site" /></label>
                    <i id="tooltipSite" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.site" />">help_outline</i>
                    <input type="text" class="form-control" id="site" name="site" value="<c:out value="${instituicao.site}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="anoFundacao"><spring:message code="label.instituicao.ano.fundacao" /></label>
                    <i id="tooltipAnoFundacao" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.ano.fundacao" />">help_outline</i>
                    <input type="text" class="form-control" id="anoFundacao" name="anoFundacao" value="<c:out value="${instituicao.anoFundacao}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="administracao"><spring:message code="label.instituicao.administracao" /></label>
                    <i id="tooltipAdministracao" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.administracao" />">help_outline</i>
                    <select class="form-control" id="administracao" name="administracao">
                        <option value="<c:out value="${instituicao.administracao.id}"/>" selected="selected">
                            <c:out value="${instituicao.administracao.administracao}" />
                        </option>
                        <c:forEach items="${listaDeAdministracao}" var="administracao">
                            <c:if test="${instituicao.administracao.id != administracao.id}">
                                <option value="<c:out value="${administracao.id}"/>"><c:out value="${administracao.administracao}" /></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-lg-3">
                    <label for="quantidadeAluno"><spring:message code="label.instituicao.quantidade.de.alunos" /></label>
                    <i id="tooltipQuantidadeAluno" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.quantidade.de.alunos" />">help_outline</i>
                    <input type="text" class="form-control" id="quantidadeAluno" name="quantidadeAluno" value="<c:out value="${instituicao.quantidadeAluno}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="quantidadeProfessor"><spring:message code="label.instituicao.quantidade.de.professores" /></label>
                    <i id="tooltipQuantidadeAluno" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.quantidade.de.professores" />">help_outline</i>
                    <input type="text" class="form-control" id="quantidadeProfessor" name="quantidadeProfessor" value="<c:out value="${instituicao.quantidadeProfessor}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="quantidadePessoalApoio"><spring:message code="label.instituicao.quantidade.de.pessoal.de.apoio" /></label>
                    <i id="tooltipQuantidadeAluno" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.quantidade.de.pessoal.de.apoio" />">help_outline</i>
                    <input type="text" class="form-control" id="quantidadePessoalApoio" name="quantidadePessoalApoio" value="<c:out value="${instituicao.quantidadePessoalApoio}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="quantidadeTurma"><spring:message code="label.instituicao.quantidade.de.turmas" /></label>
                    <i id="tooltipQuantidadeAluno" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.quantidade.de.turmas" />">help_outline</i>
                    <input type="text" class="form-control" id="quantidadeTurma" name="quantidadeTurma" value="<c:out value="${instituicao.quantidadeTurma}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="quantidadeAmbienteDidatico"><spring:message code="label.instituicao.quantidade.de.ambientes.didaticos" /></label>
                    <i id="tooltipQuantidadeAluno" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.quantidade.de.ambientes.didaticos" />">help_outline</i>
                    <input type="text" class="form-control" id="quantidadeAmbienteDidatico" name="quantidadeAmbienteDidatico" value="<c:out value="${instituicao.quantidadeAmbienteDidatico}"/>">
                </div>
                <c:forEach items="${instituicao.telefone}" var="telefone" varStatus="count">
                    <c:if test="${count.count == 1}">
                        <div id="divTelefone" class="form-group col-lg-6">
                            <label for="telefone.telefone"><spring:message code="label.instituicao.telefone" /></label>
                            <i id="tooltipTelefone" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.telefone" />">help_outline</i>
                            <i id="tooltipTelefone" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.telefone.adicionar" />" onclick="addDivTelefone($(this));">add_circle_outline</i>
                            <input type="text" class="form-control sp_celphones" id="telefone" name="telefone" value="<c:out value="${telefone.telefone}"/>">
                        </div>
                    </c:if>
                    <c:if test="${count.count > 1}">
                        <div id="divTelefone" class="form-group col-lg-6">
                            <label for="telefone.telefone"><spring:message code="label.instituicao.telefone" /></label>
                            <i id="tooltipTelefone" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.telefone" />">help_outline</i>
                            <i id="tooltipTelefone" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.telefone.adicionar" />" onclick="addDivTelefone($(this));">add_circle_outline</i>
                            <i id="tooltipTelefoneDel" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.telefone.remover" />" onclick="delDivTelefone($(this));">cancel</i>
                            <input type="text" class="form-control sp_celphones" id="telefone" name="telefone" value="<c:out value="${telefone.telefone}"/>">
                        </div>
                    </c:if>
                </c:forEach>
                <div id="divTelefoneWorkaround" class="form-group col-lg-6" style="display: none;">
                    <label for="telefone"><spring:message code="label.instituicao.telefone" /></label>
                    <input type="text" class="form-control sp_celphones" id="telefone" name="telefone">
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.instituicao.edit.endereco" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-2">
                    <label for="endereco.cep"><spring:message code="label.instituicao.cep" /></label>
                    <i id="tooltipCEP" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.cep" />">help_outline</i>
                    <input type="text" class="form-control cep_with_callback" id="endereco.cep" name="endereco.cep" value="<c:out value="${instituicao.endereco.cep}"/>">
                </div>
                <div class="form-group col-lg-10">
                    <label for="endereco.logradouro"><spring:message code="label.instituicao.logradouro" /></label>
                    <i id="tooltipLogradouro" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.logradouro" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.logradouro" name="endereco.logradouro" value="<c:out value="${instituicao.endereco.logradouro}"/>">
                </div>
                <div class="form-group col-lg-2">
                    <label for="endereco.numero"><spring:message code="label.instituicao.numero" /></label>
                    <i id="tooltipNumero" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.numero" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.numero" name="endereco.numero" value="<c:out value="${instituicao.endereco.numero}"/>">
                </div>
                <div class="form-group col-lg-4">
                    <label for="endereco.cidade"><spring:message code="label.instituicao.cidade" /></label>
                    <i id="tooltipCidade" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.cidade" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.cidade" name="endereco.cidade" value="<c:out value="${instituicao.endereco.cidade}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="endereco.uf"><spring:message code="label.instituicao.estado" /></label>
                    <i id="tooltipEstado" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.estado" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.uf" name="endereco.uf" value="<c:out value="${instituicao.endereco.uf}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="endereco.bairro"><spring:message code="label.instituicao.bairro" /></label>
                    <i id="tooltipBairro" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.bairro" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.bairro" name="endereco.bairro" value="<c:out value="${instituicao.endereco.bairro}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="endereco.pais"><spring:message code="label.instituicao.pais" /></label>
                    <i id="tooltipPais" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.pais" />">help_outline</i>
                    <input type="text" class="form-control" id="endereco.pais" name="endereco.pais" value="<c:out value="${instituicao.endereco.pais}"/>">
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <hr>
                    <h4><spring:message code="subtitle.administrador.instituicao.edit.representante" /></h4>
                    <hr>
                </div>
                <div class="form-group col-lg-6">
                    <label for="representante.nome"><spring:message code="label.instituicao.representante.nome" /></label>
                    <i id="tooltipRepresentanteNome" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.nome" />">help_outline</i>
                    <input type="text" class="form-control" id="representante.nome" name="representante.nome" value="<c:out value="${instituicao.representante.nome}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="representante.email"><spring:message code="label.instituicao.representante.email" /></label>
                    <i id="tooltipRepresentanteEmail" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.email" />">help_outline</i>
                    <input type="email" class="form-control" id="representante.email" name="representante.email" value="<c:out value="${instituicao.representante.email}"/>">
                </div>
                <div class="form-group col-lg-6">
                    <label for="representante.escolaridade"><spring:message code="label.instituicao.representante.escolaridade" /></label>
                    <i id="tooltipRepresentanteEscolaridade" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.escolaridade" />">help_outline</i>
                    <select class="form-control" id="representante.escolaridade" name="representante.escolaridade">
                        <option value="<c:out value="${instituicao.representante.escolaridade.id}"/>" selected="selected"><c:out value="${instituicao.representante.escolaridade.escolaridade}"/></option>
                        <c:forEach items="${listaDeEscolaridade}" var="escolaridade">
                            <c:if test="${escolaridade.id != instituicao.representante.escolaridade.id}">
                                <option value="<c:out value="${escolaridade.id}"/>"><c:out value="${escolaridade.escolaridade}" /></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-lg-3">
                    <label for="representante.tempoInstituicao"><spring:message code="label.instituicao.representante.tempo.na.instituicao" /></label>
                    <i id="tooltipRepresentanteTempoInstituicao" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.tempo.na.instituicao" />">help_outline</i>
                    <input type="text" class="form-control" id="representante.tempoInstituicao" name="representante.tempoInstituicao" value="<c:out value="${instituicao.representante.tempoInstituicao}"/>">
                </div>
                <div class="form-group col-lg-3">
                    <label for="representante.tempoCargo"><spring:message code="label.instituicao.representante.tempo.no.cargo" /></label>
                    <i id="tooltipRepresentanteTempoCargo" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.tempo.no.cargo" />">help_outline</i>
                    <input type="text" class="form-control" id="representante.tempoCargo" name="representante.tempoCargo" value="<c:out value="${instituicao.representante.tempoCargo}"/>">
                </div>
                <div class="form-group col-lg-12" id="divRepresentanteDocumentoVisualizar">
                    <label for="representante.documento.nome"><spring:message code="label.instituicao.representante.documento.de.nomeacao" /></label>
                    <i id="tooltipRepresentanteDocumento" class="tooltiphelper material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.documento.de.nomeacao" />">help_outline</i>
                    <a href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/docviewer/" style="text-decoration: none; color: black;">
                        <i id="tooltipRepresentanteDocumentoVisualizar" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.documento.de.nomeacao.visualizar" />">insert_photo</i>
                    </a>
                    <i onclick="representanteDocumentoEditar();" id="tooltipRepresentanteDocumentoEditar" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.documento.de.nomeacao.editar" />">mode_edit</i>
                    <input type="text" class="form-control" id="representante.documento.nome" name="representante.documento.nome" value="<c:out value="${instituicao.representante.documento.nome}"/>" readonly disabled />
                </div>
                <div class="form-group col-lg-12" style="display: none;" id="divRepresentanteDocumentoEditar">
                    <label for="representante.documento"><spring:message code="label.instituicao.representante.documento.de.nomeacao" /></label>
                    <i id="tooltipRepresentanteDocumento" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.documento.de.nomeacao" />">help_outline</i>
                    <i onclick="representanteDocumentoCancelar();" id="tooltipRepresentanteDocumentoCancelar" class="cursorpointer material-icons md-18" data-toggle="tooltip" data-placement="right" title="<spring:message code="tooltip.instituicao.dados.representante.documento.de.nomeacao.cancelar" />">cancel</i>
                    <input type="file" class="form-control" id="representante.documento" name="representante.documento" accept="pdf">
                </div>
                <div class="col-lg-12" style="text-align: center;">
                    <button type="submit" class="btn btn-primary"><spring:message code="button.atualizar" /></button>
                </div>
            </div>
        </form>
    </div>
</main>