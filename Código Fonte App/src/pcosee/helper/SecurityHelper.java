package pcosee.helper;

import org.springframework.stereotype.Service;

import pcosee.exception.SecurityException;
import pcosee.model.Funcionario;
import pcosee.model.Instituicao;

@Service
public class SecurityHelper {

    public void checkFuncionarioLogadoAdministrador(Funcionario funcionarioLogado) throws SecurityException {
        if (funcionarioLogado == null) {
            throw new SecurityException("Você não está logado!");
        }
        if (!funcionarioLogado.getPerfil().getPerfil().equals("Administrador")) {
            throw new SecurityException("Você não tem acesso à esta página!");
        }
    }

    public void checkFuncionarioLogadoAuditor(Funcionario funcionarioLogado) throws SecurityException {
        if (funcionarioLogado == null) {
            throw new SecurityException("Você não está logado!");
        }
        if (!funcionarioLogado.getPerfil().getPerfil().equals("Auditor")) {
            throw new SecurityException("Você não tem acesso à esta página!");
        }
    }

    public void checkInstituicaoLogadoRepresentante(Instituicao instituicaoLogado) throws SecurityException {
        if (instituicaoLogado == null) {
            throw new SecurityException("Você não está logado!");
        }
    }

}
