$(function () {

    $("#formFuncionarioAdd").validate({
        rules: {
            nome: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            perfil: {
                required: true,
                valueNotEquals: ""
            }
        },
        messages: {
            nome: {
                required: "Por favor, insira um nome.",
            },
            email: "Por favor, insira um e-mail válido.",
            perfil: "Por favor, selecione um perfil."
        }
    })

    $("#formFuncionarioGet").validate({
        rules: {
            nome: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            perfil: {
                required: true,
                valueNotEquals: ""
            }
        },
        messages: {
            nome: {
                required: "Por favor, insira um nome.",
            },
            email: "Por favor, insira um e-mail válido.",
            perfil: "Por favor, selecione um perfil."
        }
    })

    $("#formInstituicaoAdd").validate({
        rules: {
            "nome": {
                required: true
            },
            "cnpj": {
                required: true,
                cnpj: true
            },
            "email": {
                required: true,
                email: true
            },
            "site": {
                required: true
            },
            "anoFundacao": {
                required: true,
                number: true
            },
            "administracao": {
                required: true
            },
            "quantidadeAluno": {
                required: true,
                number: true
            },
            "quantidadeProfessor": {
                required: true,
                number: true
            },
            "quantidadePessoalApoio": {
                required: true,
                number: true
            },
            "quantidadeTurma": {
                required: true,
                number: true
            },
            "quantidadeAmbienteDidatico": {
                required: true,
                number: true
            },
            "telefone": {
                required: true
            },
            "endereco.cep": {
                required: true
            },
            "endereco.logradouro": {
                required: true
            },
            "endereco.numero": {
                required: true
            },
            "endereco.cidade": {
                required: true
            },
            "endereco.uf": {
                required: true
            },
            "endereco.bairro": {
                required: true
            },
            "endereco.pais": {
                required: true
            },
            "representante.nome": {
                required: true
            },
            "representante.email": {
                required: true
            },
            "representante.escolaridade": {
                required: true
            },
            "representante.tempoInstituicao": {
                required: true,
                number: true
            },
            "representante.tempoCargo": {
                required: true,
                number: true
            },
            "representante.documento": {
                required: true,
                extension: "pdf"
            }
        },
        messages: {
            "nome": {
                required: "Por favor, insira um nome.",
            },
            "cnpj": {
                required: "Por favor, insira um CNPJ válido.",
            },
            "email": {
                required: "Por favor, insira um e-mail válido.",
            },
            "site": {
                required: "Por favor, insira um site.",
            },
            "anoFundacao": {
                required: "Por favor, insira o ano de fundação.",
            },
            "administracao": {
                required: "Por favor, selecione o tipo de administração.",
            },
            "quantidadeAluno": {
                required: "Por favor, insira a quantidade de alunos.",
            },
            "quantidadeProfessor": {
                required: "Por favor, insira a quantidade de professores.",
            },
            "quantidadePessoalApoio": {
                required: "Por favor, insira a quantidade de pessoal de apoio.",
            },
            "quantidadeTurma": {
                required: "Por favor, insira a quantidade de turmas.",
            },
            "quantidadeAmbienteDidatico": {
                required: "Por favor, insira a quantidade de ambientes didáticos.",
            },
            "telefone": {
                required: "Por favor, insira ao menos um telefone.",
            },
            "endereco.cep": {
                required: "Por favor, insira o CEP.",
            },
            "endereco.logradouro": {
                required: "Por favor, insira o logradouro.",
            },
            "endereco.numero": {
                required: "Por favor, insira o numero.",
            },
            "endereco.cidade": {
                required: "Por favor, insira a cidade.",
            },
            "endereco.uf": {
                required: "Por favor, insira o Estado.",
            },
            "endereco.bairro": {
                required: "Por favor, insira o bairro.",
            },
            "endereco.pais": {
                required: "Por favor, insira o país.",
            },
            "representante.nome": {
                required: "Por favor, insira o nome completo.",
            },
            "representante.email": {
                required: "Por favor, insira um e-mail válido.",
            },
            "representante.escolaridade": {
                required: "Por favor, selecione a escolaridade.",
            },
            "representante.tempoCargo": {
                required: "Por favor, insira o tempo no cargo.",
            },
            "representante.tempoInstituicao": {
                required: "Por favor, insira o temp na instituição.",
            },
            "representante.documento": {
                required: "Por favor, insira um documento em formato PDF.",
                extension: "Por favor, insira um documento em formato PDF."
            }
        }
    })

    $("#formInstituicaoGet").validate({
        rules: {
            "nome": {
                required: true
            },
            "cnpj": {
                required: true,
                cnpj: true
            },
            "email": {
                required: true,
                email: true
            },
            "site": {
                required: true
            },
            "anoFundacao": {
                required: true,
                number: true
            },
            "administracao": {
                required: true
            },
            "quantidadeAluno": {
                required: true
            },
            "quantidadeProfessor": {
                required: true
            },
            "quantidadePessoalApoio": {
                required: true
            },
            "quantidadeTurma": {
                required: true
            },
            "quantidadeAmbienteDidatico": {
                required: true
            },
            "telefone": {
                required: true
            },
            "endereco.cep": {
                required: true
            },
            "endereco.logradouro": {
                required: true
            },
            "endereco.numero": {
                required: true
            },
            "endereco.cidade": {
                required: true
            },
            "endereco.uf": {
                required: true
            },
            "endereco.bairro": {
                required: true
            },
            "endereco.pais": {
                required: true
            },
            "representante.nome": {
                required: true
            },
            "representante.email": {
                required: true
            },
            "representante.escolaridade": {
                required: true
            },
            "representante.tempoInstituicao": {
                required: true
            },
            "representante.tempoCargo": {
                required: true
            },
            "representante.documento": {
                required: true,
                extension: "pdf"
            }
        },
        messages: {
            "nome": {
                required: "Por favor, insira um nome.",
            },
            "cnpj": {
                required: "Por favor, insira um CNPJ válido.",
            },
            "email": {
                required: "Por favor, insira um e-mail válido.",
            },
            "site": {
                required: "Por favor, insira um site.",
            },
            "anoFundacao": {
                required: "Por favor, insira o ano de fundação.",
            },
            "administracao": {
                required: "Por favor, selecione o tipo de administração.",
            },
            "quantidadeAluno": {
                required: "Por favor, insira a quantidade de alunos.",
            },
            "quantidadeProfessor": {
                required: "Por favor, insira a quantidade de professores.",
            },
            "quantidadePessoalApoio": {
                required: "Por favor, insira a quantidade de pessoal de apoio.",
            },
            "quantidadeTurma": {
                required: "Por favor, insira a quantidade de turmas.",
            },
            "quantidadeAmbienteDidatico": {
                required: "Por favor, insira a quantidade de ambientes didáticos.",
            },
            "telefone": {
                required: "Por favor, insira ao menos um telefone.",
            },
            "endereco.cep": {
                required: "Por favor, insira o CEP.",
            },
            "endereco.logradouro": {
                required: "Por favor, insira o logradouro.",
            },
            "endereco.numero": {
                required: "Por favor, insira o numero.",
            },
            "endereco.cidade": {
                required: "Por favor, insira a cidade.",
            },
            "endereco.uf": {
                required: "Por favor, insira o Estado.",
            },
            "endereco.bairro": {
                required: "Por favor, insira o bairro.",
            },
            "endereco.pais": {
                required: "Por favor, insira o país.",
            },
            "representante.nome": {
                required: "Por favor, insira o nome completo.",
            },
            "representante.email": {
                required: "Por favor, insira um e-mail válido.",
            },
            "representante.escolaridade": {
                required: "Por favor, selecione a escolaridade.",
            },
            "representante.tempoCargo": {
                required: "Por favor, insira o tempo no cargo.",
            },
            "representante.tempoInstituicao": {
                required: "Por favor, insira o temp na instituição.",
            },
            "representante.documento": {
                required: "Por favor, insira um documento em formato PDF.",
                extension: "Por favor, insira um documento em formato PDF."
            }
        }
    })
    
    $("#formGabaritoAvaliacaoDissertativa").validate({
        rules: {
            "doc": {
                required: true,
                extension: "pdf"
            }
        },
        messages: {
            "doc": {
                required: "Por favor, insira um documento em formato PDF.",
                extension: "Por favor, insira um documento em formato PDF."
            }
        }
    })

    $("#formPeriodoAdd").validate({
        rules: {
            inicioPrimeiraFase: {
                required: true,
                dataMQH: true

            },
            inicioSegundaFase: {
                required: true,
                dataMQP: true
            },
            fim: {
                required: true,
                dataMQS: true
            }
        },
        messages:
                {
                    inicioPrimeiraFase: {
                        required: "Insira uma data de início da primeira fase."
                    },
                    inicioSegundaFase: {
                        required: "Insira uma data de início da segunda fase."
                    },
                    fim: {
                        required: "Insira uma data de fim do período de avaliação."
                    }
                }
    })

    $("#formAdministradorDados").validate({
        rules: {
            nome: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            perfil: {
                required: true,
                valueNotEquals: ""
            }
        },
        messages: {
            nome: {
                required: "Por favor, insira um nome.",
            },
            email: "Por favor, insira um e-mail válido.",
            perfil: "Por favor, selecione um perfil."
        }
    })

    $("#formEsqueciASenha").validate({
        rules: {
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            email: "Por favor, insira um e-mail válido.",
        }
    })

    $("#formEsqueciASenhaToken").validate({
        rules: {
            token: {
                required: true
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            token: {
                required: "Por favor, insira um token.",
            },
            email: "Por favor, insira um e-mail válido."
        }
    })

    $("#formLogin").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            senha: {
                required: true
            }
        },
        messages: {
            email: "Por favor, insira um e-mail válido.",
            senha: {
                required: "Por favor, insira a senha.",
            }
        }
    })

})

function addDivTelefone(div) {
    div.closest('#divTelefone').after("<div id='divTelefone' class='form-group col-lg-6'><label for='telefone'>Telefone</label><i id='tooltipTelefone' class='tooltiphelper material-icons md-18' data-toggle='tooltip' data-placement='right' title='O telefone da instituição.'>help_outline</i><i id='tooltipTelefoneAdd' class='cursorpointer material-icons md-18' data-toggle='tooltip' data-placement='right' title='Adicionar mais um telefone da instituição.' onclick='addDivTelefone($(this));'>add_circle_outline</i><i id='tooltipTelefoneDel' class='cursorpointer material-icons md-18' data-toggle='tooltip' data-placement='right' title='Remover este telefone da instituição.' onclick='delDivTelefone($(this));'>cancel</i><input type='text' class='form-control sp_celphones' id='telefone' name='telefone'></div>");
    $('[data-toggle="tooltip"]').tooltip();
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
    },
            spOptions = {
                onKeyPress: function (val, e, field, options) {
                    field.mask(SPMaskBehavior.apply({}, arguments), options);
                }
            };

    $('.sp_celphones').mask(SPMaskBehavior, spOptions);
}

function delDivTelefone(div) {
    $('[data-toggle="tooltip"]').tooltip('hide');
    div.closest('#divTelefone').remove();
}

/* ViaCEP JS */

function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('endereco.logradouro').value = ("");
    document.getElementById('endereco.bairro').value = ("");
    document.getElementById('endereco.cidade').value = ("");
    document.getElementById('endereco.uf').value = ("");
    document.getElementById('endereco.pais').value = ("");
    document.getElementById('endereco.logradouro').removeAttribute("readonly", "yes");
    document.getElementById('endereco.bairro').removeAttribute("readonly", "yes");
    document.getElementById('endereco.cidade').removeAttribute("readonly", "yes");
    document.getElementById('endereco.uf').removeAttribute("readonly", "yes");
    document.getElementById('endereco.pais').removeAttribute("readonly", "yes");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('endereco.logradouro').value = (conteudo.logradouro);
        document.getElementById('endereco.bairro').value = (conteudo.bairro);
        document.getElementById('endereco.cidade').value = (conteudo.localidade);
        document.getElementById('endereco.uf').value = (conteudo.uf);
        document.getElementById('endereco.pais').value = ("Brasil");
        document.getElementById('endereco.logradouro').setAttribute("readonly", "yes");
        document.getElementById('endereco.bairro').setAttribute("readonly", "yes");
        document.getElementById('endereco.cidade').setAttribute("readonly", "yes");
        document.getElementById('endereco.uf').setAttribute("readonly", "yes");
        document.getElementById('endereco.pais').setAttribute("readonly", "yes");
    } //end if.
    else {
        //CEP não Encontrado.
        document.getElementById('endereco.logradouro').removeAttribute("readonly", "yes");
        document.getElementById('endereco.bairro').removeAttribute("readonly", "yes");
        document.getElementById('endereco.cidade').removeAttribute("readonly", "yes");
        document.getElementById('endereco.uf').removeAttribute("readonly", "yes");
        document.getElementById('endereco.pais').removeAttribute("readonly", "yes");
        limpa_formulário_cep();
    }
}

function pesquisacep(valor) {
    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if (validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('endereco.logradouro').value = ("...");
            document.getElementById('endereco.bairro').value = ("...");
            document.getElementById('endereco.cidade').value = ("...");
            document.getElementById('endereco.uf').value = ("...");
            document.getElementById('endereco.pais').value = ("...");

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
}
;

/* JQuery Mask */

$(function () {
    $('.date').mask('00/00/0000');
    $('.time').mask('00:00:00');
    $('.date_time').mask('00/00/0000 00:00:00');
    $('.cep').mask('00000-000');
    $('.phone').mask('0000-0000');
    $('.phone_with_ddd').mask('(00) 0000-0000');
    $('.phone_us').mask('(000) 000-0000');
    $('.mixed').mask('AAA 000-S0S');
    $('.ip_address').mask('099.099.099.099');
    $('.percent').mask('##0,00%', {reverse: true});
    $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
    $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
    $('.fallback').mask("00r00r0000", {
        translation: {
            'r': {
                pattern: /[\/]/,
                fallback: '/'
            },
            placeholder: "__/__/____"
        }
    });

    $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});

    $('.cep_with_callback').mask('00000-000', {onComplete: function (cep) {
            pesquisacep(cep)
        },
        onKeyPress: function (cep, event, currentField, options) {
            pesquisacep(cep)
        },
        onInvalid: function (val, e, field, invalid, options) {
            var error = invalid[0];
            console.log("Digit: ", error.v, " is invalid for the position: ", error.p, ". We expect something like: ", error.e);
        }
    });

    $('.crazy_cep').mask('00000-000', {onKeyPress: function (cep, e, field, options) {
            var masks = ['00000-000', '0-00-00-00'];
            mask = (cep.length > 7) ? masks[1] : masks[0];
            $('.crazy_cep').mask(mask, options);
        }});

    $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.money').mask('#.##0,00', {reverse: true});

    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
    },
            spOptions = {
                onKeyPress: function (val, e, field, options) {
                    field.mask(SPMaskBehavior.apply({}, arguments), options);
                }
            };

    $('.sp_celphones').mask(SPMaskBehavior, spOptions);

    $(".bt-mask-it").click(function () {
        $(".mask-on-div").mask("000.000.000-00");
        $(".mask-on-div").fadeOut(500).fadeIn(500)
    })

    $('pre').each(function (i, e) {
        hljs.highlightBlock(e)
    });
});

/* Tip Editar Dados Instituição */

function representanteDocumentoEditar() {
    $("#divRepresentanteDocumentoVisualizar").hide();
    $("#divRepresentanteDocumentoEditar").show();
}

function representanteDocumentoCancelar() {
    $("#divRepresentanteDocumentoVisualizar").show();
    $("#divRepresentanteDocumentoEditar").hide();
}

/* Tooltips Bootstrap */

$(function () {
    $('[data-toggle="tooltip"]').tooltip();
})

