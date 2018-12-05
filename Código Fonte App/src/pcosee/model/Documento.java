package pcosee.model;

import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Documento {

    @NotNull
    private String nome;
    @NotNull
    private String tipo;
    @NotNull
    private String arquivo;
    @NotNull
    private String extensao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

}
