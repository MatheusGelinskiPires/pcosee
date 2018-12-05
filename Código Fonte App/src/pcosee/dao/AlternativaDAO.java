package pcosee.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Alternativa;

@Service
public class AlternativaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Alternativa alternativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(alternativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Alternativa get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Alternativa alternativa;
        try {
            alternativa = datastore.find(Alternativa.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return alternativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
