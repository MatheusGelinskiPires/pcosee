package pcosee.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class GabaritoAvaliacaoObjetiva {

    @Id
    @Property("id")
    private ObjectId id;
    @Embedded
    private Instituicao instituicao;
    @Reference
    private AvaliacaoObjetiva avaliacaoObjetiva;
    @Reference
    private Periodo periodo;
    @Embedded
    private List<GabaritoQuestaoObjetiva> gabaritoQuestaoObjetiva;
    @Embedded
    private List<Status> status;
    private int nota;

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

    public AvaliacaoObjetiva getAvaliacaoObjetiva() {
        return avaliacaoObjetiva;
    }

    public void setAvaliacaoObjetiva(AvaliacaoObjetiva avaliacaoObjetiva) {
        this.avaliacaoObjetiva = avaliacaoObjetiva;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<GabaritoQuestaoObjetiva> getGabaritoQuestaoObjetiva() {
        return gabaritoQuestaoObjetiva;
    }

    public void setGabaritoQuestaoObjetiva(List<GabaritoQuestaoObjetiva> gabaritoQuestaoObjetiva) {
        this.gabaritoQuestaoObjetiva = gabaritoQuestaoObjetiva;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
