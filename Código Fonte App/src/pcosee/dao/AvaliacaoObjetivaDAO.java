package pcosee.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.AvaliacaoObjetiva;

@Service
public class AvaliacaoObjetivaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(AvaliacaoObjetiva avaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(avaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public AvaliacaoObjetiva get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        AvaliacaoObjetiva avaliacaoObjetiva;
        try {
            avaliacaoObjetiva = datastore.find(AvaliacaoObjetiva.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return avaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
