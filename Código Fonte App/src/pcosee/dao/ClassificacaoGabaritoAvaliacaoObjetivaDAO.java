package pcosee.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.ClassificacaoGabaritoAvaliacaoObjetiva;
import pcosee.model.Periodo;

@Service
public class ClassificacaoGabaritoAvaliacaoObjetivaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(ClassificacaoGabaritoAvaliacaoObjetiva glassificacaoGabaritoAvaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(glassificacaoGabaritoAvaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void update(ClassificacaoGabaritoAvaliacaoObjetiva glassificacaoGabaritoAvaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(glassificacaoGabaritoAvaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void delete(ClassificacaoGabaritoAvaliacaoObjetiva glassificacaoGabaritoAvaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.delete(glassificacaoGabaritoAvaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<ClassificacaoGabaritoAvaliacaoObjetiva> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<ClassificacaoGabaritoAvaliacaoObjetiva> listaDeClassificacaoGabaritoAvaliacaoObjetiva;
        try {
            listaDeClassificacaoGabaritoAvaliacaoObjetiva = datastore.find(ClassificacaoGabaritoAvaliacaoObjetiva.class).asList();
            datastore.getMongo().close();
            return listaDeClassificacaoGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public ClassificacaoGabaritoAvaliacaoObjetiva get(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            ClassificacaoGabaritoAvaliacaoObjetiva glassificacaoGabaritoAvaliacaoObjetiva = datastore.find(ClassificacaoGabaritoAvaliacaoObjetiva.class).field("periodo").equal(periodo).get();
            datastore.getMongo().close();
            return glassificacaoGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public ClassificacaoGabaritoAvaliacaoObjetiva get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            ClassificacaoGabaritoAvaliacaoObjetiva glassificacaoGabaritoAvaliacaoObjetiva = datastore.find(ClassificacaoGabaritoAvaliacaoObjetiva.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return glassificacaoGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
}
