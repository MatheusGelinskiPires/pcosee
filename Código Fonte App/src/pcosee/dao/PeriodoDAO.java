package pcosee.dao;

import com.mongodb.DuplicateKeyException;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.exception.BusinessException;
import pcosee.model.Periodo;

@Service
public class PeriodoDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(periodo);
            datastore.getMongo().close();
        } catch (DuplicateKeyException e) {
            throw new BusinessException("Não é possível adicionar um período que já existente.",e);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void update(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(periodo);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void delete(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.delete(periodo);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Periodo> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Periodo> listaDePeriodo;
        try {
            listaDePeriodo = datastore.find(Periodo.class).asList();
            datastore.getMongo().close();
            return listaDePeriodo;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Periodo get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            Periodo periodo = datastore.find(Periodo.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return periodo;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
}
