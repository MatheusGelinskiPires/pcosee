package pcosee.facade;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.InstituicaoDAO;
import pcosee.helper.MailHelper;
import pcosee.helper.TipsHelper;
import pcosee.model.Instituicao;

@Component
public class InstituicaoFacade {

    @Autowired
    private TipsHelper tipsHelper;
    @Autowired
    private MailHelper mailHelper;
    @Autowired
    private InstituicaoDAO instituicaoDAO;

    public void add(Instituicao instituicao) throws Exception {
        String senha = tipsHelper.generatePassword();
        this.mailHelper.sendSimpleMail(instituicao.getRepresentante().getEmail(), "Senha PCOSEE", "Senha: " + senha);
        this.mailHelper.sendSimpleMail(instituicao.getEmail(), "Senha PCOSEE", "Senha: " + senha);
        instituicao.getRepresentante().setSenha(this.tipsHelper.hashMD5Password(senha));
        this.instituicaoDAO.add(instituicao);
    }

    public void update(Instituicao instituicao) throws Exception {
        Instituicao instituicaoBanco = this.instituicaoDAO.get(instituicao.getId());
        instituicaoBanco.setNome(instituicao.getNome());
        instituicaoBanco.setCnpj(instituicao.getCnpj());
        instituicaoBanco.setEmail(instituicao.getEmail());
        instituicaoBanco.setSite(instituicao.getSite());
        instituicaoBanco.setAnoFundacao(instituicao.getAnoFundacao());
        instituicaoBanco.setAdministracao(instituicao.getAdministracao());
        instituicaoBanco.setQuantidadeAluno(instituicao.getQuantidadeAluno());
        instituicaoBanco.setQuantidadeProfessor(instituicao.getQuantidadeProfessor());
        instituicaoBanco.setQuantidadePessoalApoio(instituicao.getQuantidadePessoalApoio());
        instituicaoBanco.setQuantidadeTurma(instituicao.getQuantidadeTurma());
        instituicaoBanco.setQuantidadeAmbienteDidatico(instituicao.getQuantidadeAmbienteDidatico());
        instituicaoBanco.setTelefone(instituicao.getTelefone());
        instituicaoBanco.setEndereco(instituicao.getEndereco());
        instituicaoBanco.getRepresentante().setNome(instituicao.getRepresentante().getNome());
        instituicaoBanco.getRepresentante().setEmail(instituicao.getRepresentante().getEmail());
        instituicaoBanco.getRepresentante().setEscolaridade(instituicao.getRepresentante().getEscolaridade());
        instituicaoBanco.getRepresentante().setTempoCargo(instituicao.getRepresentante().getTempoCargo());
        instituicaoBanco.getRepresentante().setTempoInstituicao(instituicao.getRepresentante().getTempoInstituicao());
        if (!"".equals(instituicao.getRepresentante().getDocumento().getNome())) {
            instituicaoBanco.getRepresentante().setDocumento(instituicao.getRepresentante().getDocumento());
        }
        this.instituicaoDAO.update(instituicaoBanco);
    }

    public void delete(Instituicao instituicao) throws Exception {
        instituicao = this.instituicaoDAO.get(instituicao.getId());
        this.instituicaoDAO.delete(instituicao);
    }

    public List<Instituicao> get() throws Exception {
        return this.instituicaoDAO.get();
    }

    public Instituicao get(ObjectId id) throws Exception {
        return this.instituicaoDAO.get(id);
    }

    public Instituicao get(String email, String senha) throws Exception {
        return this.instituicaoDAO.get(email, senha);
    }

    public Instituicao get(String email) throws Exception {
        return this.instituicaoDAO.get(email);
    }

    public void passwordReset(String email) throws Exception {
        Instituicao instituicao = this.instituicaoDAO.get(email);
        String senha = this.tipsHelper.generatePassword();
        this.mailHelper.sendSimpleMail(instituicao.getRepresentante().getEmail(), "Nova senha PCOSEE", "Nova senha: " + senha);
        this.mailHelper.sendSimpleMail(instituicao.getEmail(), "Nova senha PCOSEE", "Nova senha: " + senha);
        instituicao.getRepresentante().setSenha(this.tipsHelper.hashMD5Password(senha));
        this.instituicaoDAO.update(instituicao);
    }

}
