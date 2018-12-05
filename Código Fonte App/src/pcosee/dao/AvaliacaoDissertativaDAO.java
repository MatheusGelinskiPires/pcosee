package pcosee.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.AvaliacaoDissertativa;

@Service
public class AvaliacaoDissertativaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(AvaliacaoDissertativa avaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(avaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public AvaliacaoDissertativa get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        AvaliacaoDissertativa avaliacaoDissertativa;
        try {
            avaliacaoDissertativa = datastore.find(AvaliacaoDissertativa.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return avaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
