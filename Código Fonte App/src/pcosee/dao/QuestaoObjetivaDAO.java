package pcosee.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.QuestaoObjetiva;

@Service
public class QuestaoObjetivaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(QuestaoObjetiva questaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(questaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public QuestaoObjetiva get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        QuestaoObjetiva questaoObjetiva;
        try {
            questaoObjetiva = datastore.find(QuestaoObjetiva.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return questaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
