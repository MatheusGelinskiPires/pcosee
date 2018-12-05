<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main role="main" class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-4 offset-lg-4">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Área Logada</h5>
                            <form id="formLogin" action="<c:out value="${pageContext.request.contextPath}"></c:out>/login" method="POST">
                                <div class="form-group">
                                    <label for="email">E-mail</label>
                                    <input type="email" class="form-control" id="email" name="email" style="text-align: center">
                                </div>
                                <div class="form-group">
                                    <label for="senha">Senha</label>
                                    <input type="password" class="form-control" name="senha" id="senha" style="text-align: center">
                                </div>
                                <a style="text-decoration: none; color: black" href="<c:out value="${pageContext.request.contextPath}"></c:out>/esqueciASenha" class="btn btn-default card-link">Esqueci a senha!</a>
                                <input type="submit" class="btn btn-dark" value="Entrar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>