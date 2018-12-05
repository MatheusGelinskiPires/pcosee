package pcosee.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.FindOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.GabaritoAvaliacaoObjetiva;
import pcosee.model.Instituicao;
import pcosee.model.Periodo;

@Service
public class GabaritoAvaliacaoObjetivaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(gabaritoAvaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public void update(GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(gabaritoAvaliacaoObjetiva);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public GabaritoAvaliacaoObjetiva get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva;
        try {
            gabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return gabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public GabaritoAvaliacaoObjetiva get(ObjectId id,Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva;
        try {
            gabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).field("id").equal(id).field("instituicao.id").equal(instituicao.getId()).get();
            datastore.getMongo().close();
            return gabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<GabaritoAvaliacaoObjetiva> get(Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoObjetiva> listaDeGabaritoAvaliacaoObjetiva;
        try {
            listaDeGabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).field("instituicao.cnpj").equal(instituicao.getCnpj()).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoObjetiva> get(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoObjetiva> listaDeGabaritoAvaliacaoObjetiva;
        try {
            listaDeGabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).field("periodo").equal(periodo).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoObjetiva> getSorted(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoObjetiva> listaDeGabaritoAvaliacaoObjetiva;
        try {
            listaDeGabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).field("periodo").equal(periodo).order("-nota,-instituicao.quantidadeProfessor,-instituicao.quantidadeTurma,-instituicao.quantidadeAluno,-instituicao.quantidadePessoalApoio,instituicao.anoFundacao").asList(new FindOptions().limit(10));
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<GabaritoAvaliacaoObjetiva> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoObjetiva> listaDeGabaritoAvaliacaoObjetiva;
        try {
            listaDeGabaritoAvaliacaoObjetiva = datastore.find(GabaritoAvaliacaoObjetiva.class).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoObjetiva;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
