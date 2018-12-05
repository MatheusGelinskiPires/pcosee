/* Arquivo JavaScritp para funcionalidades relacionadas ao perfil de Administrador */

/* DataTable Tabela de Avaliações */

$(document)
        .ready(
                function () {
                    $('#tabelaDeGabaritoAvaliacaoObjetiva')
                            .DataTable(
                                    {
                                        language: {
                                            "sEmptyTable": "Nenhum registro encontrado",
                                            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                                            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                                            "sInfoPostFix": "",
                                            "sInfoThousands": ".",
                                            "sLengthMenu": "_MENU_ resultados por página",
                                            "sLoadingRecords": "Carregando...",
                                            "sProcessing": "Processando...",
                                            "sZeroRecords": "Nenhum registro encontrado",
                                            "sSearch": "Pesquisar",
                                            "oPaginate": {
                                                "sNext": "Próximo",
                                                "sPrevious": "Anterior",
                                                "sFirst": "Primeiro",
                                                "sLast": "Último"
                                            },
                                            "oAria": {
                                                "sSortAscending": ": Ordenar colunas de forma ascendente",
                                                "sSortDescending": ": Ordenar colunas de forma descendente"
                                            }
                                        }
                                    });
                    $('#tabelaDeGabaritoAvaliacaoObjetiva').removeClass(
                            'display').addClass(
                            'table table-striped table-bordered');
                });

$(document)
        .ready(
                function () {
                    $('#tabelaDeGabaritoAvaliacaoDissertativa')
                            .DataTable(
                                    {
                                        language: {
                                            "sEmptyTable": "Nenhum registro encontrado",
                                            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                                            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                                            "sInfoPostFix": "",
                                            "sInfoThousands": ".",
                                            "sLengthMenu": "_MENU_ resultados por página",
                                            "sLoadingRecords": "Carregando...",
                                            "sProcessing": "Processando...",
                                            "sZeroRecords": "Nenhum registro encontrado",
                                            "sSearch": "Pesquisar",
                                            "oPaginate": {
                                                "sNext": "Próximo",
                                                "sPrevious": "Anterior",
                                                "sFirst": "Primeiro",
                                                "sLast": "Último"
                                            },
                                            "oAria": {
                                                "sSortAscending": ": Ordenar colunas de forma ascendente",
                                                "sSortDescending": ": Ordenar colunas de forma descendente"
                                            }
                                        }
                                    });
                    $('#tabelaDeGabaritoAvaliacaoDissertativa').removeClass(
                            'display').addClass(
                            'table table-striped table-bordered');
                });