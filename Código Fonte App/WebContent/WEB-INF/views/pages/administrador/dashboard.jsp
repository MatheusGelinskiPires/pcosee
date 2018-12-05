<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.administrador.dashboard" /></h1>
    </div>
    <hr>
    <div>
        <div class="row" style="text-align:center;">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <canvas id="dashboard_admin"></canvas>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12" style="text-align:center;">
                <h3><spring:message code="subtitle.administrador.dashboard.usuario" /></h3>
                <p><spring:message code="text.administrador.dashboard.usuario" /></p>
                <ul class="0-legend">
                    <li>
                        <span style="background-color:#878f99"></span><spring:message code="span.administrador.dashboard.usuario.funcionario" />(<c:out value="${func}"></c:out>)
                    </li>
                    <li>
                        <span style="background-color:#6b5b95"></span><spring:message code="span.administrador.dashboard.usuario.instituicao" />(<c:out value="${inst}"></c:out>)
                    </li>
                </ul>
            </div>
        </div>
        <hr>
        <div class="col-12" style="text-align:center;">
            <h1><spring:message code="subtitle.administrador.dashboard.funcao" /></h1>
            <b><p><spring:message code="text.administrador.dashboard.funcao.instituicao" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/instituicao/"><spring:message code="link.administrador.dashboard.funcao.instituicao" /></a></p></b>
            <b><p><spring:message code="text.administrador.dashboard.funcao.funcionario" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/funcionario/"><spring:message code="link.administrador.dashboard.funcao.funcionario" /></a></p></b>
            <b><p><spring:message code="text.administrador.dashboard.funcao.periodo" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/administrador/periodo/"><spring:message code="link.administrador.dashboard.funcao.periodo" /></a></p></b>
        </div>
        <hr>
    </div>
</main>
<script>
    var ctx = document.getElementById("dashboard_admin").getContext('2d');

    var chartData = [<c:out value="${func}"></c:out>,<c:out value="${inst}"></c:out>];
    var chartLabels = ['Funcionários', 'Instituições'];

    var chart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: chartLabels,
            datasets: [{
                    backgroundColor: [
                        "#878f99",
                        "#6b5b95",
                        "#FFA500",
                        "#9b59b6",
                    ],
                    data: chartData
                }]
        },
        options: {
            legend: {
                display: false
            },
            legendCallback: function (chart) {
                var text = [];
                text.push('<ul class="0-legend">');
                var ds = chart.data.datasets[0];
                var sum = ds.data.reduce(function add(a, b) {
                    return a + b;
                }, 0);
                for (var i = 0; i < ds.data.length; i++) {
                    text.push('<li>');
                    var perc = Math.round(100 * ds.data[i] / sum, 0);
                    text.push('<span style="background-color:' + ds.backgroundColor[i] + '">' + '</span>' + chart.data.labels[i] + ' (' + ds.data[i] + ') (' + perc + '%)');
                    text.push('</li>');
                }
                text.push('</ul>');
                return text.join("");
            }
        }
    });
</script>