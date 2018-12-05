package pcosee.facade;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.EscolaridadeDAO;
import pcosee.model.Escolaridade;

@Component
public class EscolaridadeFacade {

    @Autowired
    private EscolaridadeDAO escolaridadeDAO;

    public void add(Escolaridade escolaridade) throws Exception {
        this.escolaridadeDAO.add(escolaridade);
    }

    public List<Escolaridade> get() throws Exception {
        return this.escolaridadeDAO.get();
    }

    public Escolaridade get(ObjectId id) throws Exception {
        return this.escolaridadeDAO.get(id);
    }

}
