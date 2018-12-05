package pcosee.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Perfil;

@Service
public class PerfilDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Perfil perfil) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(perfil);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Perfil get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Perfil perfil;
        try {
            perfil = datastore.find(Perfil.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return perfil;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Perfil> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Perfil> listaDePerfil;
        try {
            listaDePerfil = datastore.find(Perfil.class).asList();
            datastore.getMongo().close();
            return listaDePerfil;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
