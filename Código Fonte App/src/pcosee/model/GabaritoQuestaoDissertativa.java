package pcosee.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class GabaritoQuestaoDissertativa {

    @Reference
    private QuestaoDissertativa questaoDissertativa;
    @NotNull
    private String resposta;
    @Embedded
    private List<Auditoria> auditoria;

    public QuestaoDissertativa getQuestaoDissertativa() {
        return questaoDissertativa;
    }

    public void setQuestaoDissertativa(QuestaoDissertativa questaoDissertativa) {
        this.questaoDissertativa = questaoDissertativa;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<Auditoria> getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(List<Auditoria> auditoria) {
        this.auditoria = auditoria;
    }
    
}
