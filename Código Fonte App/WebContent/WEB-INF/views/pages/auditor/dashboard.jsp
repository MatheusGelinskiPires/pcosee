<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1><spring:message code="title.auditor.dashboard" /></h1>
    </div>
    <hr>
    <div>
        <div class="row" style="text-align:center;">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <canvas id="dashboard_auditor"></canvas>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12" style="text-align:center;">
                <h3><spring:message code="subtitle.auditor.dashboard.avaliacao" /></h3>
                <p><spring:message code="text.auditor.dashboard.avaliacao" /></p>
                <ul class="0-legend">
                    <li>
                        <span style="background-color:#878f99"></span><spring:message code="span.auditor.dashboard.avaliacao" />(<c:out value="${listaDeGabaritoAvaliacaoDissertativaCount}"></c:out>)
                    </li>
                </ul>
            </div>
        </div>
        <hr>
        <div class="col-12" style="text-align:center;">
            <h1><spring:message code="subtitle.auditor.dashboard.funcao" /></h1>
            <b><p><spring:message code="text.auditor.dashboard.funcao.cadastro" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/auditor/dados"><spring:message code="link.auditor.dashboard.funcao.cadastro" /></a></p></b>
            <b><p><spring:message code="text.auditor.dashboard.funcao.avaliacao" /><a href="<c:out value="${pageContext.request.contextPath}"></c:out>/auditor/avaliacao/dissertativa"><spring:message code="link.auditor.dashboard.funcao.avaliacao" /></a></p></b>
        </div>
        <hr>
    </div>
</main>
<script>
    var ctx = document.getElementById("dashboard_auditor").getContext('2d');

    var chartData = [<c:out value="${listaDeGabaritoAvaliacaoDissertativaCount}"></c:out>];
    var chartLabels = ['Avaliações Dissertativas'];

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

    var myLegendContainer = document.getElementById("legend");
// generate HTML legend
    myLegendContainer.innerHTML = chart.generateLegend();
// bind onClick event to all LI-tags of the legend
    var legendItems = myLegendContainer.getElementsByTagName('li');
    for (var i = 0; i < legendItems.length; i += 1) {
        legendItems[i].addEventListener("click", legendClickCallback, false);
    }

    function legendClickCallback(event) {
        event = event || window.event;

        var target = event.target || event.srcElement;
        while (target.nodeName !== 'LI') {
            target = target.parentElement;
        }
        var parent = target.parentElement;
        var chartId = parseInt(parent.classList[0].split("-")[0], 10);
        var chart = Chart.instances[chartId];
        var index = Array.prototype.slice.call(parent.children).indexOf(target);
        var meta = chart.getDatasetMeta(0);
        console.log(index);
        var item = meta.data[index];

        if (item.hidden === null || item.hidden === false) {
            item.hidden = true;
            target.classList.add('hidden');
        } else {
            target.classList.remove('hidden');
            item.hidden = null;
        }
        chart.update();
    }
</script>