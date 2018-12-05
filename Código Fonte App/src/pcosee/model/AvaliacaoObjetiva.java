package pcosee.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class AvaliacaoObjetiva {

    @Id
    @Property("id")
    private ObjectId id;
    @Reference
    List<QuestaoObjetiva> questaoObjetiva;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<QuestaoObjetiva> getQuestaoObjetiva() {
        return questaoObjetiva;
    }

    public void setQuestaoObjetiva(List<QuestaoObjetiva> questaoObjetiva) {
        this.questaoObjetiva = questaoObjetiva;
    }

}
