<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.instituicao.dashboard" /></h1>
    </div>
    <hr>
    <div class="row" >
        <div class="col-lg-6 col-md-6 col-sm-12" style="text-align:center;">
            <h3><spring:message code="subtitle.instituicao.dashboard.objetiva" /></h3>
            <p><spring:message code="text.instituicao.dashboard.objetiva" /></p>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12">
            <canvas id="dashboard_inst_obj"></canvas>
        </div>
        <hr>
        <div class="col-lg-6 col-md-6 col-sm-12" style="text-align:center;">
            <h3><spring:message code="subtitle.instituicao.dashboard.dissertativa" /></h3>
            <p><spring:message code="text.instituicao.dashboard.dissertativa" /></p>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12">
            <canvas id="dashboard_inst_dis"></canvas>
        </div>
    </div>
    <hr>
    <div class="col-12" style="text-align:center;">
        <h1><spring:message code="subtitle.instituicao.dashboard.funcao" /></h1>
        <b><p><spring:message code="text.instituicao.dashboard.funcao.cadastro" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/dados"><spring:message code="link.instituicao.dashboard.funcao.cadastro" /></a></p></b>
        <b><p><spring:message code="text.instituicao.dashboard.funcao.altera" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/dados"><spring:message code="link.instituicao.dashboard.funcao.altera" /></a>.</p></b>
        <b><p><spring:message code="text.instituicao.dashboard.funcao.objetiva" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/objetiva"><spring:message code="link.instituicao.dashboard.funcao.objetiva" /></a>.</p></b>
        <b><p><spring:message code="text.instituicao.dashboard.funcao.dissertativa" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/instituicao/avaliacao/dissertativa"><spring:message code="link.instituicao.dashboard.funcao.dissertativa" /></a>.</p></b>
        </div>
        <hr>
    </main>

    <script>
        var ctx = document.getElementById("dashboard_inst_obj").getContext('2d');

        var chartData = [<c:out value="${dashDataObj}" escapeXml="false"></c:out>];
        var chartLabels = [<c:out value="${dashLabelObj}" escapeXml="false"></c:out>];

        var chart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: chartLabels,
                datasets: [{
                        data: chartData
                    }]
            },
            options: {
                legend: {
                    display: false
                }
            }
        });

    </script>

    <script>
        var ctx = document.getElementById("dashboard_inst_dis").getContext('2d');

        var chartData = [<c:out value="${dashDataDis}" escapeXml="false"></c:out>];
        var chartLabels = [<c:out value="${dashLabelDis}" escapeXml="false"></c:out>];

        var chart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: chartLabels,
                datasets: [{
                        data: chartData
                    }]
            },
            options: {
                legend: {
                    display: false
                }
            }
        });

</script>
