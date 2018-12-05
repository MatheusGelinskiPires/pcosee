package pcosee.facade;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.QuestaoDissertativaDAO;
import pcosee.model.QuestaoDissertativa;

@Component
public class QuestaoDissertativaFacade {

    @Autowired
    private QuestaoDissertativaDAO questaoDissertativaDAO;

    public void add(QuestaoDissertativa questaoDissertativa) throws Exception {
        this.questaoDissertativaDAO.add(questaoDissertativa);
    }

    public QuestaoDissertativa get(ObjectId id) throws Exception {
        return this.questaoDissertativaDAO.get(id);
    }

}
