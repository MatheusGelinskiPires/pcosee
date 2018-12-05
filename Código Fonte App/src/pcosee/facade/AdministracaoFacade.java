package pcosee.facade;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.AdministracaoDAO;
import pcosee.model.Administracao;

@Component
public class AdministracaoFacade {

    @Autowired
    private AdministracaoDAO administracaoDAO;

    public void add(Administracao administracao) throws Exception {
        this.administracaoDAO.add(administracao);
    }

    public List<Administracao> get() throws Exception {
        return this.administracaoDAO.get();
    }

    public Administracao get(ObjectId id) throws Exception {
        return this.administracaoDAO.get(id);
    }

}
