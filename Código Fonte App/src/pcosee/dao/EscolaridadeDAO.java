package pcosee.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Escolaridade;

@Service
public class EscolaridadeDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Escolaridade escolaridade) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(escolaridade);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Escolaridade get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Escolaridade escolaridade;
        try {
            escolaridade = datastore.find(Escolaridade.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return escolaridade;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Escolaridade> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Escolaridade> listaDeEscolaridade;
        try {
            listaDeEscolaridade = datastore.find(Escolaridade.class).asList();
            datastore.getMongo().close();
            return listaDeEscolaridade;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
