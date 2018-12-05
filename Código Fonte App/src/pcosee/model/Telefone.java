package pcosee.model;

import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Telefone {

    @NotNull
    String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
