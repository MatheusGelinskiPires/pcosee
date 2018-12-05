package pcosee.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Administracao;

@Service
public class AdministracaoDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Administracao administracao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(administracao);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Administracao get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Administracao administracao;
        try {
            administracao = datastore.find(Administracao.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return administracao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Administracao> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Administracao> listaDeAdministracao;
        try {
            listaDeAdministracao = datastore.find(Administracao.class).asList();
            datastore.getMongo().close();
            return listaDeAdministracao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
