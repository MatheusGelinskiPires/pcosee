package pcosee.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class AvaliacaoDissertativa {

    @Id
    @Property("id")
    private ObjectId id;
    @Reference
    private List<QuestaoDissertativa> questaoDissertativa;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<QuestaoDissertativa> getQuestaoDissertativa() {
        return questaoDissertativa;
    }

    public void setQuestaoDissertativa(List<QuestaoDissertativa> questaoDissertativa) {
        this.questaoDissertativa = questaoDissertativa;
    }

}
