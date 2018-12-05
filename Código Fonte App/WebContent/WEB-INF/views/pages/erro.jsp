<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main role="main" class="container">
    <div class="container-fluid" id="erroBox">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-6 offset-lg-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h4 class="card-title">Ops!</h4>
                            <hr/>
                            <div class="col">
                                <c:out value="${mensagem}"></c:out>
                            </div>
                            <hr/>
                            <div class="col">
                                <c:out value="${erro}"></c:out>
                            </div>
                            <hr/>
                            <div class="col">
                                <c:out value="${instrucao}"></c:out>
                            </div>
                            <hr/>
                            <div class="col">
                                <a href="<c:out value="${link}"></c:out>">
                                    <button class="btn btn-dark">Voltar</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>