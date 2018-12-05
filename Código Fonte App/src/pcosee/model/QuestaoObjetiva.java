package pcosee.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
@Indexes(@Index(fields = {@Field("enunciado")}, options = @IndexOptions(unique = true)))
public class QuestaoObjetiva {

    @Id
    @Property("id")
    private ObjectId id;
    @NotNull
    private String enunciado;
    @Reference
    private List<Alternativa> alternativa;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Alternativa> getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(List<Alternativa> alternativa) {
        this.alternativa = alternativa;
    }

}
