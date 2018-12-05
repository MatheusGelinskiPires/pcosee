/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcosee.controller;

import javax.servlet.ServletException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pcosee.exception.SecurityException;
import pcosee.exception.BusinessException;
import pcosee.exception.CustomException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({RuntimeException.class})
    public String runtimeExceptionError(Model model, Exception s) {
        model.addAttribute("mensagem", "Exceção causada por erro de execução.");
        model.addAttribute("erro", s.getMessage());
        model.addAttribute("instrucao", "Entre em contato com o administrador do sistema!");
        model.addAttribute("link", "/PCOSEE/");
        s.printStackTrace();
        return "erro";
    }

    @ExceptionHandler({BusinessException.class})
    public String businessExceptionError(Model model, BusinessException s) {
        model.addAttribute("mensagem", "Exceção causada por regra de negócio.");
        model.addAttribute("erro", s.getMessage());
        model.addAttribute("instrucao", "Entre em contato com o administrador do sistema!");
        model.addAttribute("link", "/PCOSEE/");
        s.printStackTrace();
        return "erro";
    }
    
    @ExceptionHandler({CustomException.class})
    public String customExceptionError(Model model, CustomException s) {
        model.addAttribute("mensagem", "Exceção causada por um erro não mapeado.");
        model.addAttribute("erro", s.getMessage());
        model.addAttribute("instrucao", "Entre em contato com o administrador do sistema!");
        model.addAttribute("link", "/PCOSEE/");
        s.printStackTrace();
        return "erro";
    }
    
    @ExceptionHandler({ServletException.class})
    public String servletExceptionError(Model model, CustomException s) {
        model.addAttribute("mensagem", "Exceção causada por um erro não mapeado.");
        model.addAttribute("erro", s.getMessage());
        model.addAttribute("instrucao", "Entre em contato com o administrador do sistema!");
        model.addAttribute("link", "/PCOSEE/");
        s.printStackTrace();
        return "erro";
    }

    @ExceptionHandler({SecurityException.class})
    public String securityExceptionError(Model model, SecurityException s) {
        model.addAttribute("mensagem", "Acesso não autorizado.");
        model.addAttribute("erro", s.getMessage());
        model.addAttribute("instrucao", "Faça login novamente ou verifique seu acesso.");
        model.addAttribute("link", "/PCOSEE/");
        s.printStackTrace();
        return "erro";
    }

}
