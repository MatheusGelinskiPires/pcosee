package pcosee.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Instituicao;

@Service
public class InstituicaoDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(instituicao);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void update(Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(instituicao);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void delete(Instituicao instituicao) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.delete(instituicao);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Instituicao> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Instituicao> listaDeInstituicao;
        try {
            listaDeInstituicao = datastore.find(Instituicao.class).asList();
            datastore.getMongo().close();
            return listaDeInstituicao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Instituicao get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Instituicao instituicao;
        try {
            instituicao = datastore.find(Instituicao.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return instituicao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Instituicao get(String email, String senha) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Instituicao instituicao;
        try {
            instituicao = datastore.find(Instituicao.class).field("representante.email").equal(email).field("representante.senha").equal(senha).get();
            datastore.getMongo().close();
            return instituicao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Instituicao get(String email) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Instituicao instituicao;
        try {
            instituicao = datastore.find(Instituicao.class).field("representante.email").equal(email).get();
            datastore.getMongo().close();
            return instituicao;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
}
