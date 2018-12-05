package pcosee.facade;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.AlternativaDAO;
import pcosee.model.Alternativa;

@Component
public class AlternativaFacade {

    @Autowired
    private AlternativaDAO alternativaDAO;

    public void add(Alternativa alternativa) throws Exception {
        this.alternativaDAO.add(alternativa);
    }

    public Alternativa get(ObjectId id) throws Exception {
        return this.alternativaDAO.get(id);
    }

}
