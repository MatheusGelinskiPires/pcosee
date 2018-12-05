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
import org.springframework.web.bind.annotation.RequestParam;
import pcosee.exception.BusinessException;
import pcosee.exception.CustomException;

import pcosee.exception.SecurityException;
import pcosee.facade.AdministracaoFacade;
import pcosee.facade.AvaliacaoDissertativaFacade;
import pcosee.facade.AvaliacaoObjetivaFacade;
import pcosee.facade.EscolaridadeFacade;
import pcosee.facade.GabaritoAvaliacaoObjetivaFacade;
import pcosee.facade.GabaritoAvaliacaoDissertativaFacade;
import pcosee.facade.InstituicaoFacade;
import pcosee.facade.PeriodoFacade;
import pcosee.helper.PeriodoHelper;
import pcosee.helper.SecurityHelper;
import pcosee.helper.TipsHelper;
import pcosee.model.Documento;
import pcosee.model.GabaritoAvaliacaoDissertativa;
import pcosee.model.GabaritoAvaliacaoObjetiva;
import pcosee.model.Instituicao;
import pcosee.model.Periodo;
import pcosee.model.Status;

@RequestMapping("/")
@Controller
public class InstituicaoController {

    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private TipsHelper tipsHelper;
    @Autowired
    private AdministracaoFacade administracaoFacade;
    @Autowired
    private EscolaridadeFacade escolaridadeFacade;
    @Autowired
    private InstituicaoFacade instituicaoFacade;
    @Autowired
    private GabaritoAvaliacaoObjetivaFacade gabaritoAvaliacaoObjetivaFacade;
    @Autowired
    private AvaliacaoObjetivaFacade avaliacaoObjetivaFacade;
    @Autowired
    private GabaritoAvaliacaoDissertativaFacade gabaritoAvaliacaoDissertativaFacade;
    @Autowired
    private AvaliacaoDissertativaFacade avaliacaoDissertativaFacade;
    @Autowired
    private PeriodoFacade periodoFacade;
    @Autowired
    private PeriodoHelper periodoHelper;

    // Acesso Instituição //
    @GetMapping({"/instituicao", "/instituicao/dashboard"})
    public String instituicaoDashboard(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            
            Status status = new Status();
            status.setStatus("Finalizada");
            List<GabaritoAvaliacaoDissertativa> listDis = this.gabaritoAvaliacaoDissertativaFacade.get(instituicaoLogado,status);
            List<GabaritoAvaliacaoObjetiva> listObj = this.gabaritoAvaliacaoObjetivaFacade.get(instituicaoLogado);

            String dashLabelDis = "";
            String dashDataDis = "";

            for (int j = 0; j <= listDis.size()-1; j++) {
                dashLabelDis = dashLabelDis.concat("\""+this.tipsHelper.dateStr(listDis.get(j).getPeriodo().getInicioSegundaFase())+" a "+this.tipsHelper.dateStr(listDis.get(j).getPeriodo().getFim())+"\",");
                dashDataDis = dashDataDis.concat("\""+String.valueOf(listDis.get(j).getNota())+"\",");
            }
            
            model.addAttribute("dashLabelDis", dashLabelDis.toString());
            model.addAttribute("dashDataDis", dashDataDis.toString());

            String dashLabelObj = "";
            String dashDataObj = "";
            
            for (int j = 0; j <= listObj.size()-1; j++) {
                dashLabelObj = dashLabelObj.concat("\""+this.tipsHelper.dateStr(listObj.get(j).getPeriodo().getInicioPrimeiraFase()) + " a " + this.tipsHelper.dateStr(listObj.get(j).getPeriodo().getInicioSegundaFase()))+"\",";
                dashDataObj = dashDataObj.concat("\""+String.valueOf(listObj.get(j).getNota())+"\",");
            }

            model.addAttribute("dashLabelObj", dashLabelObj.toString());
            model.addAttribute("dashDataObj", dashDataObj.toString());

            return "/instituicao/dashboard";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/sobre")
    public String instituicaoSobre(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            return "/instituicao/sobre";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/dados")
    public String instituicaoDados(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("listaDeAdministracao", this.administracaoFacade.get());
            model.addAttribute("listaDeEscolaridade", this.escolaridadeFacade.get());
            session.setAttribute("docview", this.instituicaoFacade.get(instituicaoLogado.getId()).getRepresentante().getDocumento().getArquivo());
            model.addAttribute("emCurso", this.periodoHelper.isEmPercurso());
            return "/instituicao/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/docviewer")
    public String instituicaoDocviewer(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            session.setAttribute("docview", instituicaoLogado.getRepresentante().getDocumento().getArquivo());
            return "/instituicao/docviewer";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/instituicao/dados/update")
    public String instituicaoDadosUpdate(@Valid @ModelAttribute("instituicao") Instituicao instituicao,
            BindingResult result, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            if (result.hasErrors()) {
                for (ObjectError erro : result.getAllErrors()) {
                    throw new Exception(erro.getDefaultMessage());
                }
            }
            this.instituicaoFacade.update(instituicao);
            session.setAttribute("instituicaoLogado", this.instituicaoFacade.get(instituicao.getId()));
            return "redirect:/instituicao/dados";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping({"/instituicao/avaliacao/objetiva", "/instituicao/avaliacao/objetiva/list"})
    public String instituicaoAvaliacaoObjetivaList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("listaDeGabaritoAvaliacaoObjetiva", this.gabaritoAvaliacaoObjetivaFacade.list(instituicaoLogado));
            return "/instituicao/avaliacao/objetiva/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/avaliacao/objetiva/get/{id}")
    public String instituicaoAvaliacaoObjetivaGet(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("gabaritoAvaliacaoObjetiva", this.gabaritoAvaliacaoObjetivaFacade.get(new ObjectId(id)));
            return "/instituicao/avaliacao/objetiva/get";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/avaliacao/objetiva/add/{id}")
    public String instituicaoAvaliacaoObjetivaAdd(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("avaliacaoObjetiva", this.avaliacaoObjetivaFacade.get(new ObjectId("5b8598a5862bd400dcf07fe3"), this.periodoFacade.get(new ObjectId(id))));
            model.addAttribute("periodo", this.periodoFacade.get(new ObjectId(id)));
            return "/instituicao/avaliacao/objetiva/add";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/instituicao/avaliacao/objetiva/add")
    public String instituicaoAvaliacaoObjetivaAddPost(Model model, HttpSession session, String[] questaoObjetiva, Periodo periodo) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            this.gabaritoAvaliacaoObjetivaFacade.add(instituicaoLogado, periodo, questaoObjetiva);
            return "redirect:/instituicao/avaliacao/objetiva";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping({"/instituicao/avaliacao/dissertativa", "/instituicao/avaliacao/dissertativa/list"})
    public String instituicaoAvaliacaoDissertativaList(Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("listaDeGabaritoAvaliacaoDissertativa", this.gabaritoAvaliacaoDissertativaFacade.list(instituicaoLogado));
            return "/instituicao/avaliacao/dissertativa/list";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/avaliacao/dissertativa/get/{id}")
    public String instituicaoAvaliacaoDissertativaGet(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("gabaritoAvaliacaoDissertativa", this.gabaritoAvaliacaoDissertativaFacade.get(new ObjectId(id)));
            return "/instituicao/avaliacao/dissertativa/get";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/avaliacao/dissertativa/add/{id}")
    public String instituicaoAvaliacaoDissertativaAdd(@PathVariable String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            model.addAttribute("avaliacaoDissertativa", this.avaliacaoDissertativaFacade.get(new ObjectId("5b85a34e862bd400dccaa736")));
            model.addAttribute("periodo", this.periodoFacade.get(new ObjectId(id)));
            return "/instituicao/avaliacao/dissertativa/add";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/instituicao/avaliacao/dissertativa/add")
    public String instituicaoAvaliacaoDissertativaAddPost(HttpServletRequest request, Model model, HttpSession session, Periodo periodo, @RequestParam("doc") Documento documento) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            this.gabaritoAvaliacaoDissertativaFacade.add(instituicaoLogado, periodo, documento, request);
            return "redirect:/instituicao/avaliacao/dissertativa";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("instituicao");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("instituicao");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("instituicao");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/instituicao/avaliacao/dissertativa/docviewer/{id}")
    public String auditorAvaliacaoDissertativaDocviewer(@PathVariable("id") String id, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            Instituicao instituicaoLogado = (Instituicao) session.getAttribute("instituicaoLogado");
            this.securityHelper.checkInstituicaoLogadoRepresentante(instituicaoLogado);
            GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(new ObjectId(id));
            model.addAttribute("gabaritoAvaliacaoDissertativa", gabaritoAvaliacaoDissertativa);
            model.addAttribute("docview", gabaritoAvaliacaoDissertativa.getDocumento().getArquivo());
            return "/instituicao/avaliacao/dissertativa/docviewer";
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

    // Fim Acesso Instituição //
}
