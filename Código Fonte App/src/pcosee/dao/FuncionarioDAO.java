package pcosee.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcosee.config.MongoConfig;
import pcosee.model.Funcionario;

@Service
public class FuncionarioDAO {

    @Autowired
    private MongoConfig mongoAutoConfig;

    public void add(Funcionario funcionario) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(funcionario);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void update(Funcionario funcionario) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.save(funcionario);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public void delete(Funcionario funcionario) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        try {
            datastore.delete(funcionario);
            datastore.getMongo().close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public List<Funcionario> get() throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        List<Funcionario> listaDeFuncionario = new ArrayList<Funcionario>();
        try {
            listaDeFuncionario = datastore.find(Funcionario.class).asList();
            datastore.getMongo().close();
            return listaDeFuncionario;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Funcionario get(ObjectId id) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Funcionario funcionario;
        try {
            funcionario = datastore.find(Funcionario.class).field("id").equal(id).get();
            datastore.getMongo().close();
            return funcionario;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Funcionario get(String email, String senha) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Funcionario funcionario;
        try {
            funcionario = datastore.find(Funcionario.class).field("email").equal(email).field("senha").equal(senha).get();
            datastore.getMongo().close();
            return funcionario;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }

    public Funcionario get(String email) throws Exception {
        Datastore datastore = this.mongoAutoConfig.connectMongo();
        Funcionario funcionario;
        try {
            funcionario = datastore.find(Funcionario.class).field("email").equal(email).get();
            datastore.getMongo().close();
            return funcionario;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (datastore != null) {
                datastore.getMongo().close();
            }
        }
    }
}
