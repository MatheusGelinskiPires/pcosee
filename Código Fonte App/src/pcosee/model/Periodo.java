package pcosee.model;

import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Indexes(@Index(fields = {@Field("inicioPrimeiraFase"), @Field("inicioSegundaFase"), @Field("fim")}, options = @IndexOptions(unique = true)))
public class Periodo {

    @Id
    @Property("id")
    private ObjectId id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioPrimeiraFase;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioSegundaFase;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fim;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getInicioPrimeiraFase() {
        return inicioPrimeiraFase;
    }

    public void setInicioPrimeiraFase(Date inicioPrimeiraFase) {
        this.inicioPrimeiraFase = inicioPrimeiraFase;
    }

    public Date getInicioSegundaFase() {
        return inicioSegundaFase;
    }

    public void setInicioSegundaFase(Date inicioSegundaFase) {
        this.inicioSegundaFase = inicioSegundaFase;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

}
