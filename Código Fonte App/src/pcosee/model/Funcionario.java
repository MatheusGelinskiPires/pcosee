package pcosee.model;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
@Indexes(@Index(fields = {@Field("email")}, options = @IndexOptions(unique = true)))
public class Funcionario {

    @Id
    @Property("id")
    private ObjectId id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @Reference
    @Valid
    private Perfil perfil;
    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario(ObjectId id, @NotNull String nome, @NotNull String email, @Valid Perfil perfil,
            String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.senha = senha;
    }

    public Funcionario() {
        super();
    }

}
