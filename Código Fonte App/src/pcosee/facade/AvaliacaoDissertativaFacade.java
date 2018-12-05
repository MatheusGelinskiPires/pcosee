package pcosee.facade;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.AvaliacaoDissertativaDAO;
import pcosee.model.AvaliacaoDissertativa;

@Component
public class AvaliacaoDissertativaFacade {

    @Autowired
    private AvaliacaoDissertativaDAO avaliacaoDissertativaDAO;

    public void add(AvaliacaoDissertativa avaliacaoDissertativa) throws Exception {
        this.avaliacaoDissertativaDAO.add(avaliacaoDissertativa);
    }

    public AvaliacaoDissertativa get(ObjectId id) throws Exception {
        return this.avaliacaoDissertativaDAO.get(id);
    }

}
