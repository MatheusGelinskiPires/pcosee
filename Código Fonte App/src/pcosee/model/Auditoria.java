package pcosee.model;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Auditoria {

    private Funcionario funcionario;
    private Date data;
    private int nota;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
