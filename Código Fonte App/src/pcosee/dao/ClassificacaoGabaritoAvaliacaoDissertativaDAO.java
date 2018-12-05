package pcosee.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.ClassificacaoGabaritoAvaliacaoDissertativa;
import pcosee.model.Periodo;

@Service
public class ClassificacaoGabaritoAvaliacaoDissertativaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(ClassificacaoGabaritoAvaliacaoDissertativa glassificacaoGabaritoAvaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(glassificacaoGabaritoAvaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void update(ClassificacaoGabaritoAvaliacaoDissertativa glassificacaoGabaritoAvaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(glassificacaoGabaritoAvaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void delete(ClassificacaoGabaritoAvaliacaoDissertativa glassificacaoGabaritoAvaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.delete(glassificacaoGabaritoAvaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<ClassificacaoGabaritoAvaliacaoDissertativa> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<ClassificacaoGabaritoAvaliacaoDissertativa> listaDeClassificacaoGabaritoAvaliacaoDissertativa;
        try {
            listaDeClassificacaoGabaritoAvaliacaoDissertativa = datastore.find(ClassificacaoGabaritoAvaliacaoDissertativa.class).asList();
            datastore.getMongo().close();
            return listaDeClassificacaoGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public ClassificacaoGabaritoAvaliacaoDissertativa get(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            ClassificacaoGabaritoAvaliacaoDissertativa glassificacaoGabaritoAvaliacaoDissertativa = datastore.find(ClassificacaoGabaritoAvaliacaoDissertativa.class).field("periodo").equal(periodo).get();
            datastore.getMongo().close();
            return glassificacaoGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public ClassificacaoGabaritoAvaliacaoDissertativa get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            ClassificacaoGabaritoAvaliacaoDissertativa glassificacaoGabaritoAvaliacaoDissertativa = datastore.find(ClassificacaoGabaritoAvaliacaoDissertativa.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return glassificacaoGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
}
