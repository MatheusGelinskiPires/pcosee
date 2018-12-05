package pcosee.facade;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.FuncionarioDAO;
import pcosee.helper.MailHelper;
import pcosee.helper.TipsHelper;
import pcosee.model.Funcionario;

@Component
public class FuncionarioFacade {

    @Autowired
    private TipsHelper tipsHelper;
    @Autowired
    private MailHelper mailHelper;
    @Autowired
    private FuncionarioDAO funcionarioDAO;

    public void add(Funcionario funcionario) throws Exception {
        String senha = this.tipsHelper.generatePassword();
        this.mailHelper.sendSimpleMail(funcionario.getEmail(), "Senha PCOSEE", "Senha: " + senha);
        funcionario.setSenha(this.tipsHelper.hashMD5Password(senha));
        this.funcionarioDAO.add(funcionario);
    }

    public void update(Funcionario funcionario) throws Exception {
        Funcionario funcionarioBanco = this.funcionarioDAO.get(funcionario.getId());
        funcionarioBanco.setNome(funcionario.getNome());
        funcionarioBanco.setEmail(funcionario.getEmail());
        funcionarioBanco.setPerfil(funcionario.getPerfil());
        this.funcionarioDAO.update(funcionarioBanco);
    }

    public void delete(Funcionario funcionario) throws Exception {
        this.funcionarioDAO.delete(funcionario);
    }

    public List<Funcionario> get() throws Exception {
        return this.funcionarioDAO.get();
    }

    public Funcionario get(ObjectId id) throws Exception {
        Funcionario funcionario = this.funcionarioDAO.get(id);
        if (funcionario == null) {
            throw new Exception("Funcionário não encontrado. ID: " + id);
        }
        return funcionario;
    }

    public Funcionario get(String email, String senha) throws Exception {
        return this.funcionarioDAO.get(email, senha);
    }

    public Funcionario get(String email) throws Exception {
        return this.funcionarioDAO.get(email);
    }

    public void passwordReset(String email) throws Exception {
        Funcionario funcionario = this.funcionarioDAO.get(email);
        String senha = this.tipsHelper.generatePassword();
        this.mailHelper.sendSimpleMail(funcionario.getEmail(), "Nova senha PCOSEE", "Nova senha: " + senha);
        funcionario.setSenha(this.tipsHelper.hashMD5Password(senha));
        this.funcionarioDAO.update(funcionario);
    }

}
