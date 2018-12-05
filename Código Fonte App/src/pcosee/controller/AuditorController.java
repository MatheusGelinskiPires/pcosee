package pcosee.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import pcosee.facade.FuncionarioFacade;
import pcosee.facade.GabaritoAvaliacaoDissertativaFacade;
import pcosee.facade.PerfilFacade;
import pcosee.helper.SecurityHelper;
import pcosee.model.Funcionario;
import pcosee.model.GabaritoAvaliacaoDissertativa;

@RequestMapping("/")
@Controller
public class AuditorController {

    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private PerfilFacade perfilFacade;
    @Autowired
    private FuncionarioFacade funcionarioFacade;
    @Autowired
    private GabaritoAvaliacaoDissertativaFacade gabaritoAvaliacaoDissertativaFacade;

    // Acesso Auditor //
    @GetMapping({"/auditor", "/auditor/dashboard"})
    public String auditorDashboard(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(funcionarioLogado);
            model.addAttribute("listaDeGabaritoAvaliacaoDissertativa", listaDeGabaritoAvaliacaoDissertativa);
            model.addAttribute("listaDeGabaritoAvaliacaoDissertativaCount", listaDeGabaritoAvaliacaoDissertativa.size());
            return "/auditor/dashboard";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping("/auditor/sobre")
    public String auditorSobre(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            return "/auditor/sobre";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/auditor/dados")
    public String auditorDados(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            model.addAttribute("listaDePerfil", this.perfilFacade.get());
            return "/auditor/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/auditor/dados/update")
    public String auditorDadosUpdate(@Valid @ModelAttribute("funcionario") Funcionario funcionario,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new BusinessException(erro.getDefaultMessage());
                }
            }
            this.funcionarioFacade.update(funcionario);
            session.setAttribute("funcionarioLogado", this.funcionarioFacade.get(funcionario.getId()));
            return "redirect:/auditor/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }

    @GetMapping({"/auditor/avaliacao/dissertativa", "/auditor/avaliacao/dissertativa/list"})
    public String auditorAvaliacaoDissertativaList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(funcionarioLogado);
            model.addAttribute("listaDeGabaritoAvaliacaoDissertativa", listaDeGabaritoAvaliacaoDissertativa);
            return "/auditor/avaliacao/dissertativa/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping("/auditor/avaliacao/dissertativa/audit/{id}")
    public String auditorAvaliacaoDissertativaGet(@PathVariable("id") String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(new ObjectId(id), funcionarioLogado);
            model.addAttribute("gabaritoAvaliacaoDissertativa", gabaritoAvaliacaoDissertativa);
            return "/auditor/avaliacao/dissertativa/audit";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }
    
    @PostMapping("/auditor/avaliacao/dissertativa/audit/{id}")
    public String auditorAvaliacaoDissertativaAudit(@PathVariable("id") String id, Model model, HttpSession session, HttpServletRequest request) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            this.gabaritoAvaliacaoDissertativaFacade.audit(id, funcionarioLogado, request);
            return "redirect:/auditor/avaliacao/dissertativa/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }
    
    @GetMapping("/auditor/avaliacao/dissertativa/docviewer/{id}")
    public String auditorAvaliacaoDissertativaDocviewer(@PathVariable("id") String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionarioLogado = (Funcionario) session.getAttribute("funcionarioLogado");
            this.securityHelper.checkFuncionarioLogadoAuditor(funcionarioLogado);
            GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(new ObjectId(id), funcionarioLogado);
            model.addAttribute("gabaritoAvaliacaoDissertativa", gabaritoAvaliacaoDissertativa);
            model.addAttribute("docview", gabaritoAvaliacaoDissertativa.getDocumento().getArquivo());
            return "/auditor/avaliacao/dissertativa/docviewer";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("auditor");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("auditor");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("auditor");
            throw new CustomException(customException);
        }
    }

    // Fim Acesso Auditor //
}
