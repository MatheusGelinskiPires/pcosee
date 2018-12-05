package pcosee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pcosee.exception.BusinessException;
import pcosee.exception.CustomException;

import pcosee.exception.SecurityException;
import pcosee.facade.FuncionarioFacade;
import pcosee.facade.InstituicaoFacade;
import pcosee.helper.TipsHelper;
import pcosee.helper.TokenHelper;
import pcosee.model.Funcionario;
import pcosee.model.Instituicao;

@RequestMapping("/")
@Controller
public class PortalController {

    @Autowired
    private FuncionarioFacade funcionarioFacade;
    @Autowired
    private InstituicaoFacade instituicaoFacade;
    @Autowired
    private TipsHelper tipsHelper;
    @Autowired
    private TokenHelper tokenHelper;

    // Acesso Anônimo //
    @GetMapping({"/", "/login"})
    public String login(HttpSession session) {
        String link;
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionarioLogado");
        Instituicao instituicao= (Instituicao) session.getAttribute("instituicaoLogado");
        if(funcionario==null && instituicao==null){
            link="index";
        } else {
            if (funcionario!=null){
                link="redirect:/"+funcionario.getPerfil().getPerfil().toLowerCase();
            } else {
                link="redirect:/instituicao";
            }
        }
        return link;
    }

    @PostMapping("/login")
    public String login(String email, String senha, Model model, HttpSession session) throws SecurityException, BusinessException, CustomException {
        try {
            if ("".equals(email) || "".equals(senha)) {
                throw new SecurityException("E-mail ou senha incorretos.");
            }
            Funcionario funcionarioLogado = this.funcionarioFacade.get(email, this.tipsHelper.hashMD5Password(senha));
            if (funcionarioLogado != null) {
                session.setAttribute("funcionarioLogado", funcionarioLogado);
                return "redirect:/" + funcionarioLogado.getPerfil().getPerfil().toLowerCase();
            } else {
                Instituicao instituicaoLogado = this.instituicaoFacade.get(email, this.tipsHelper.hashMD5Password(senha));
                if (instituicaoLogado != null) {
                    session.setAttribute("instituicaoLogado", instituicaoLogado);
                    return "redirect:/instituicao/";
                } else {
                    throw new SecurityException("Credenciais não encontradas no sistema.");
                }
            }
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("portal");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("portal");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("portal");
            throw new CustomException(customException);
        }

    }

    @GetMapping("/esqueciASenha")
    public String esqueciASenha() {
        return "esqueciASenha";
    }

    @PostMapping("/esqueciASenha")
    public String esqueciASenha(String email, Model model) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionario = this.funcionarioFacade.get(email);
            Instituicao instituicao = this.instituicaoFacade.get(email);
            if (funcionario != null) {
                this.tokenHelper.enviaToken(email);
            } else {
                if (instituicao != null) {
                    this.tokenHelper.enviaToken(email);
                } else {
                    throw new Exception("E-mail não encontrado no sistema.");
                }
            }
            model.addAttribute("email", email);
            return "esqueciASenhaToken";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("portal");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("portal");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("portal");
            throw new CustomException(customException);
        }
    }

    @PostMapping("/esqueciASenhaToken")
    public String esqueciASenhaToken(String email, String token, Model model) throws SecurityException, BusinessException, CustomException {
        try {
            Funcionario funcionario = this.funcionarioFacade.get(email);
            Instituicao instituicao = this.instituicaoFacade.get(email);
            if (funcionario != null) {
                this.tokenHelper.validaToken(token, email);
                this.funcionarioFacade.passwordReset(email);
            } else {
                if (instituicao != null) {
                    this.tokenHelper.validaToken(token, email);
                    this.instituicaoFacade.passwordReset(email);
                } else {
                    throw new Exception("E-mail não encontrado no sistema.");
                }
            }
            return "redirect:/";
        } catch (SecurityException e) {
            throw new SecurityException(e.getMessage());
        } catch (BusinessException e) {
            e.setOrigem("portal");
            throw new BusinessException(e);
        } catch (CustomException e) {
            e.setOrigem("portal");
            throw new CustomException(e);
        } catch (Exception e) {
            CustomException customException = new CustomException(e);
            customException.setOrigem("portal");
            throw new CustomException(customException);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }
    
}
