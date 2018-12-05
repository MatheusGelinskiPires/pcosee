package pcosee.facade;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.PerfilDAO;
import pcosee.model.Perfil;

@Component
public class PerfilFacade {

    @Autowired
    private PerfilDAO perfilDAO;

    public void add(Perfil perfil) throws Exception {
        this.perfilDAO.add(perfil);
    }

    public List<Perfil> get() throws Exception {
        return this.perfilDAO.get();
    }

    public Perfil get(ObjectId id) throws Exception {
        return this.perfilDAO.get(id);
    }

}
