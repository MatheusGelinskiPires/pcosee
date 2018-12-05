package pcosee.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pcosee.exception.BusinessException;
import pcosee.exception.CustomException;

import pcosee.exception.SecurityException;
import pcosee.facade.AdministracaoFacade;
import pcosee.facade.EscolaridadeFacade;
import pcosee.facade.FuncionarioFacade;
import pcosee.facade.InstituicaoFacade;
import pcosee.facade.PerfilFacade;
import pcosee.facade.PeriodoFacade;
import pcosee.helper.PeriodoHelper;
import pcosee.helper.SecurityHelper;
import pcosee.model.Funcionario;
import pcosee.model.Instituicao;
import pcosee.model.Periodo;

@RequestMapping("/")
@Controller
public class AdministradorController {

    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private PerfilFacade perfilFacade;
    @Autowired
    private FuncionarioFacade funcionarioFacade;
    @Autowired
    private AdministracaoFacade administracaoFacade;
    @Autowired
    private EscolaridadeFacade escolaridadeFacade;
    @Autowired
    private InstituicaoFacade instituicaoFacade;
    @Autowired
    private PeriodoFacade periodoFacade;
    @Autowired
    private PeriodoHelper periodoHelper;

    // Acesso Administrador //
    @GetMapping({"/administrador", "/administrador/dashboard"})
    public String administradorDashboard(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            int func = this.funcionarioFacade.get().size();
            int inst = this.instituicaoFacade.get().size();
            model.addAttribute("inst", inst);
            model.addAttribute("func", func);
            return "/administrador/dashboard";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping("/administrador/sobre")
    public String administradorSobre(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            return "/administrador/sobre";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/dados")
    public String administradorDados(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDePerfil", this.perfilFacade.get());
            return "/administrador/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/administrador/dados/update")
    public String administradorDadosUpdate(@Valid @ModelAttribute("funcionario") Funcionario funcionario,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new BusinessException(erro.getDefaultMessage());
                }
            }
            this.funcionarioFacade.update(funcionario);
            session.setAttribute("funcionarioLogado", this.funcionarioFacade.get(funcionario.getId()));
            return "redirect:/administrador/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping({"/administrador/funcionario", "/administrador/funcionario/list"})
    public String administradorFuncionarioList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDeFuncionario", this.funcionarioFacade.get());
            return "/administrador/funcionario/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/funcionario/add")
    public String administradorFuncionarioAdd(HttpSession session, Model model) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDePerfil", this.perfilFacade.get());
            return "/administrador/funcionario/add";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/administrador/funcionario/add")
    public String administradorFuncionarioAdd(@Valid @ModelAttribute("funcionario") Funcionario funcionario,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new ServletException(erro.getDefaultMessage());
                }
            }
            this.funcionarioFacade.add(funcionario);
            return "redirect:/administrador/funcionario/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/funcionario/get/{id}")
    public String administradorFuncionarioGet(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDePerfil", this.perfilFacade.get());
            model.addAttribute("funcionario", this.funcionarioFacade.get(new ObjectId(id)));
            return "/administrador/funcionario/get";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/administrador/funcionario/update")
    public String administradorFuncionarioUpdate(@Valid @ModelAttribute("funcionario") Funcionario funcionario,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new ServletException(erro.getDefaultMessage());
                }
            }
            this.funcionarioFacade.update(funcionario);
            return "redirect:/administrador/funcionario/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/funcionario/delete/{id}")
    public String administradorFuncionarioDelete(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            this.funcionarioFacade.delete(this.funcionarioFacade.get(new ObjectId(id)));
            return "redirect:/administrador/funcionario/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/instituicao/add")
    public String administradorInstituicaoAdd(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDeAdministracao", this.administracaoFacade.get());
            model.addAttribute("listaDeEscolaridade", this.escolaridadeFacade.get());
            return "/administrador/instituicao/add";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/administrador/instituicao/add")
    public String administradorInstituicaoAdd(@Valid @ModelAttribute("instituicao") Instituicao instituicao,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new ServletException(erro.getDefaultMessage());
                }
            }
            this.instituicaoFacade.add(instituicao);
            return "redirect:/administrador/instituicao/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/administrador/instituicao/update")
    public String administradorInstituicaoUpdate(@Valid @ModelAttribute("instituicao") Instituicao instituicao,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new ServletException(erro.getDefaultMessage());
                }
            }
            this.instituicaoFacade.update(instituicao);
            return "redirect:/administrador/instituicao/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping({"/administrador/instituicao", "/administrador/instituicao/list"})
    public String administradorInstituicaoList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDeInstituicao", this.instituicaoFacade.get());
            return "/administrador/instituicao/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/instituicao/get/{id}")
    public String administradorInstituicaoGet(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDeAdministracao", this.administracaoFacade.get());
            model.addAttribute("listaDeEscolaridade", this.escolaridadeFacade.get());
            model.addAttribute("instituicao", this.instituicaoFacade.get(new ObjectId(id)));
            model.addAttribute("emCurso", this.periodoHelper.isEmPercurso());
            session.setAttribute("docview", this.instituicaoFacade.get(new ObjectId(id)).getRepresentante().getDocumento().getArquivo());
            return "/administrador/instituicao/get";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    
    // DocViewer //
    @GetMapping("/administrador/instituicao/docviewer/")
    public String documentoViewer(Model model, HttpServletResponse response, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            return "/administrador/instituicao/docviewer";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/administrador/instituicao/delete/{id}")
    public String administradorInstituicaoDelete(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            this.instituicaoFacade.delete(this.instituicaoFacade.get(new ObjectId(id)));
            return "redirect:/administrador/instituicao/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping({"/administrador/periodo", "/administrador/periodo/list"})
    public String administradorAvaliacaoList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            model.addAttribute("listaDePeriodo", this.periodoFacade.get());
            return "/administrador/periodo/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    
    @PostMapping("/administrador/periodo/add")
    public String administradorAvaliacaoAdd(Model model, HttpSession session, Periodo periodo) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            this.periodoFacade.add(periodo);
            return "redirect:/administrador/periodo/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping("/administrador/periodo/delete/{id}")
    public String administradorAvaliacaoDelete(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAdministrador(funcionarioLogado);
            this.periodoFacade.delete(this.periodoFacade.get(new ObjectId(id)));
            return "redirect:/administrador/periodo/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("administrador");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("administrador");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("administrador");
            throw new CustomException(customException);
        }
    }
    // Fim Acesso Administrador //
}