package pcosee.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class GabaritoAvaliacaoDissertativa {

    @Id
    @Property("id")
    private ObjectId id;
    @Embedded
    private Instituicao instituicao;
    @Reference
    private Periodo periodo;
    @Reference
    private AvaliacaoDissertativa avaliacaoDissertativa;
    @Embedded
    private List<GabaritoQuestaoDissertativa> gabaritoQuestaoDissertativa;
    @Embedded
    private List<Status> status;
    @Embedded
    private Documento documento;
    
    private float nota;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public AvaliacaoDissertativa getAvaliacaoDissertativa() {
        return avaliacaoDissertativa;
    }

    public void setAvaliacaoDissertativa(AvaliacaoDissertativa avaliacaoDissertativa) {
        this.avaliacaoDissertativa = avaliacaoDissertativa;
    }

    public List<GabaritoQuestaoDissertativa> getGabaritoQuestaoDissertativa() {
        return gabaritoQuestaoDissertativa;
    }

    public void setGabaritoQuestaoDissertativa(List<GabaritoQuestaoDissertativa> gabaritoQuestaoDissertativa) {
        this.gabaritoQuestaoDissertativa = gabaritoQuestaoDissertativa;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

}
