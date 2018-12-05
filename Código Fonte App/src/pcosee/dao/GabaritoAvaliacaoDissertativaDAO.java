package pcosee.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.FindOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.GabaritoAvaliacaoDissertativa;
import pcosee.model.Instituicao;
import pcosee.model.Funcionario;
import pcosee.model.Periodo;
import pcosee.model.Status;

@Service
public class GabaritoAvaliacaoDissertativaDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(gabaritoAvaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public void update(GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(gabaritoAvaliacaoDissertativa);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public GabaritoAvaliacaoDissertativa get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa;
        try {
            gabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return gabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoDissertativa> get(Funcionario funcionario) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaGabaritoAvaliacaoDissertativa;
        try {
            listaGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("gabaritoQuestaoDissertativa.auditoria.funcionario.id").notEqual(funcionario.getId()).field("status.status").contains("Aguardando Auditoria").asList();
            datastore.getMongo().close();
            return listaGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<GabaritoAvaliacaoDissertativa> get(Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("instituicao.cnpj").equal(instituicao.getCnpj()).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoDissertativa> get(Instituicao instituicao, Status status) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("instituicao.cnpj").equal(instituicao.getCnpj()).field("status.status").contains(status.getStatus()).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoDissertativa> get(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("periodo").equal(periodo).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoDissertativa> getSorted(Periodo periodo) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("periodo").equal(periodo).order("-nota,-instituicao.quantidadeProfessor,-instituicao.quantidadeTurma,-instituicao.quantidadeAluno,-instituicao.quantidadePessoalApoio,instituicao.anoFundacao").asList(new FindOptions().limit(3));
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
    
    public List<GabaritoAvaliacaoDissertativa> getNotEqual(Periodo periodo, Status status) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).field("periodo").equal(periodo).field("status.status").notEqual(status.getStatus()).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<GabaritoAvaliacaoDissertativa> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa;
        try {
            listaDeGabaritoAvaliacaoDissertativa = datastore.find(GabaritoAvaliacaoDissertativa.class).asList();
            datastore.getMongo().close();
            return listaDeGabaritoAvaliacaoDissertativa;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

}
