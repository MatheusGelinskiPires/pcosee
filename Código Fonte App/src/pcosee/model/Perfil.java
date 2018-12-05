package pcosee.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
@Indexes(@Index(fields = { @Field("perfil")}, options = @IndexOptions(unique = true)))
public class Perfil {

    @Id
    @Property("id")
    private ObjectId id;
    @NotNull
    private String perfil;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
