<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main role="main" class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-4 offset-lg-4">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Esqueci a Senha</h5>
                            <form id="formEsqueciASenhaToken" action="<c:out value="${pageContext.request.contextPath}"></c:out>/esqueciASenhaToken" method="POST">
                                <div class="form-group">
                                    <label for="email">E-mail</label>
                                    <input type="email" class="form-control" id="email" name="email" style="text-align: center" value="<c:out value="${email}"></c:out>" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Token</label>
                                        <i id="tooltipToken" class="material-icons md-18" data-toggle="tooltip" data-placement="right" title="O token enviado para o e-mail acima.">help_outline</i></label>
                                    <input type="text" class="form-control" id="token" name="token" style="text-align: center" required>
                                    </div>
                                    <a style="text-decoration: none; color: black" class="btn btn-default card-link" href="<c:out value="${pageContext.request.contextPath}"></c:out>/">Voltar</a>
                                <input type="submit" class="btn btn-dark" value="Enviar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>