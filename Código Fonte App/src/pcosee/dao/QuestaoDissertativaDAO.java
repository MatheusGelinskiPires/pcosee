package pcosee.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.QuestaoDissertativa;

@Service
public class QuestaoDissertativaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(QuestaoDissertativa questaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(questaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public QuestaoDissertativa get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        QuestaoDissertativa questaoDissertativa;
        try {
            questaoDissertativa = datastore.find(QuestaoDissertativa.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return questaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
