package pcosee.model;

import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

@Embedded
@Indexes(@Index(fields = {@Field("email")}, options = @IndexOptions(unique = true)))
public class Representante {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @Reference
    private Escolaridade escolaridade;
    @NotNull
    private String tempoInstituicao;
    @NotNull
    private String tempoCargo;
    @Embedded
    private Documento documento;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getTempoInstituicao() {
        return tempoInstituicao;
    }

    public void setTempoInstituicao(String tempoInstituicao) {
        this.tempoInstituicao = tempoInstituicao;
    }

    public String getTempoCargo() {
        return tempoCargo;
    }

    public void setTempoCargo(String tempoCargo) {
        this.tempoCargo = tempoCargo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
