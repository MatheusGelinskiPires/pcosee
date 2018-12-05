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
public class ClassificacaoGabaritoAvaliacaoDissertativa {
    
    @Id
    @Property("id")
    private ObjectId id;
    @Reference
    private Periodo periodo;
    @Reference
    private List<GabaritoAvaliacaoDissertativa> gabaritoAvaliacaoDissertativa;

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

    public List<GabaritoAvaliacaoDissertativa> getGabaritoAvaliacaoDissertativa() {
        return gabaritoAvaliacaoDissertativa;
    }

    public void setGabaritoAvaliacaoDissertativa(List<GabaritoAvaliacaoDissertativa> gabaritoAvaliacaoDissertativa) {
        this.gabaritoAvaliacaoDissertativa = gabaritoAvaliacaoDissertativa;
    }
    
    
    
}
