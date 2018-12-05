/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcosee.model;

import java.util.List;
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
@Indexes(@Index(fields = {@Field("periodo")}, options = @IndexOptions(unique = true)))
public class ClassificacaoGabaritoAvaliacaoObjetiva {
    
    @Id
    @Property("id")
    private ObjectId id;
    @Reference
    private Periodo periodo;
    @Reference
    private List<GabaritoAvaliacaoObjetiva> gabaritoAvaliacaoObjetiva;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<GabaritoAvaliacaoObjetiva> getGabaritoAvaliacaoObjetiva() {
        return gabaritoAvaliacaoObjetiva;
    }

    public void setGabaritoAvaliacaoObjetiva(List<GabaritoAvaliacaoObjetiva> gabaritoAvaliacaoObjetiva) {
        this.gabaritoAvaliacaoObjetiva = gabaritoAvaliacaoObjetiva;
    }
    
    
    
}
