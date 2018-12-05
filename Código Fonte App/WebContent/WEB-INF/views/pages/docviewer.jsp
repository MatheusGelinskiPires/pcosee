<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://mozilla.github.io/pdf.js/build/pdf.js"></script>
<main role="main" class="container">
    <div class="col-lg-12" style="text-align: center;">
        <h1>Visualizar Documento</h1>
    </div>
    <hr>
    <div class="col-lg-10 offset-lg-1">
        <div class="col-lg-12" style="text-align: center;"><h5>Visualizar Documento</h5></div>
        <hr>
        <canvas id="divPdfContainer" class="col-lg-12" style="text-align: center;"></canvas>
        <hr>
        <div class="col-lg-12" style="text-align: center;"><button onclick="javascript:history.back()" class="btn btn-dark" >Voltar</button></div>
    </div>
    <hr>
</main>
<script type="text/javascript">

    var pdfData = atob('<c:out value="${docview}"></c:out>');
    var pdfjsLib = window['pdfjs-dist/build/pdf'];

    pdfjsLib.GlobalWorkerOptions.workerSrc = 'http://mozilla.github.io/pdf.js/build/pdf.worker.js';

    var loadingTask = pdfjsLib.getDocument({data: pdfData});
    loadingTask.promise.then(function (pdf) {
        var pageNumber = 1;
        pdf.getPage(pageNumber).then(function (page) {
            var scale = 1.5;
            var viewport = page.getViewport(scale);

            var canvas = document.getElementById('divPdfContainer');
            var context = canvas.getContext('2d');
            canvas.height = viewport.height;
            canvas.width = viewport.width;

            var renderContext = {
                canvasContext: context,
                viewport: viewport
            };
            var renderTask = page.render(renderContext);
            renderTask.then(function () {
            });
        });
    }, function (reason) {
        console.error(reason);
    });
</script>