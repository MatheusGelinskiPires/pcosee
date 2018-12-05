package pcosee.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
@Indexes(@Index(fields = {@Field("nome"), @Field("cnpj"), @Field("email")}, options = @IndexOptions(unique = true)))
public class Instituicao {

    @Id
    @Property("id")
    private ObjectId id;
    @NotNull
    private String nome;
    @NotNull
    private String cnpj;
    @NotNull
    private String site;
    @NotNull
    private String email;
    @NotNull
    private int anoFundacao;
    @NotNull
    private int quantidadeProfessor;
    @NotNull
    private int quantidadeAmbienteDidatico;
    @NotNull
    private int quantidadeAluno;
    @NotNull
    private int quantidadeTurma;
    @NotNull
    private int quantidadePessoalApoio;
    @Embedded
    private List<Telefone> telefone;
    @Embedded
    private Endereco endereco;
    @Reference
    private Administracao administracao;
    @Embedded
    Representante representante;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public int getQuantidadeProfessor() {
        return quantidadeProfessor;
    }

    public void setQuantidadeProfessor(int quantidadeProfessor) {
        this.quantidadeProfessor = quantidadeProfessor;
    }

    public int getQuantidadeAmbienteDidatico() {
        return quantidadeAmbienteDidatico;
    }

    public void setQuantidadeAmbienteDidatico(int quantidadeAmbienteDidatico) {
        this.quantidadeAmbienteDidatico = quantidadeAmbienteDidatico;
    }

    public int getQuantidadeAluno() {
        return quantidadeAluno;
    }

    public void setQuantidadeAluno(int quantidadeAluno) {
        this.quantidadeAluno = quantidadeAluno;
    }

    public int getQuantidadeTurma() {
        return quantidadeTurma;
    }

    public void setQuantidadeTurma(int quantidadeTurma) {
        this.quantidadeTurma = quantidadeTurma;
    }

    public int getQuantidadePessoalApoio() {
        return quantidadePessoalApoio;
    }

    public void setQuantidadePessoalApoio(int quantidadePessoalApoio) {
        this.quantidadePessoalApoio = quantidadePessoalApoio;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Administracao getAdministracao() {
        return administracao;
    }

    public void setAdministracao(Administracao administracao) {
        this.administracao = administracao;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

}
