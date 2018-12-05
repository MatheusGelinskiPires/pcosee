package pcosee.config;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Value;
import java.util.logging.Logger;
import pcosee.model.*;

@Service
public class MongoConfig {
    
    @Value("${app.nome}")
    private String appNome;
    @Value("${mongo.host}")
    private String mongoHost;
    @Value("${mongo.port}")
    private int mongoPort;
    @Value("${mongo.database}")
    private String mongoDatabase;
    @Value("${mongo.user}")
    private String mongoUser;
    @Value("${mongo.pass}")
    private String mongoPass;
    @Value("${mongo.maxWaitTime}")
    private int maxWaitTime;
    @Value("${mongo.socketTimeout}")
    private int socketTimeout;
    @Value("${mongo.connectTimeout}")
    private int connectTimeout;
    
    public Datastore connectMongo() {
        Logger mongoLogger = Logger.getLogger( "org.mongodb" );
        mongoLogger.setLevel(Level.SEVERE);
        MongoCredential credential = MongoCredential.createCredential(this.mongoUser, this.mongoDatabase, this.mongoPass.toCharArray());
        ServerAddress addr = new ServerAddress(this.mongoHost, this.mongoPort);
        MongoClientOptions options = new MongoClientOptions.Builder().applicationName(this.appNome).maxWaitTime(this.maxWaitTime).socketTimeout(this.socketTimeout).connectTimeout(this.connectTimeout).build();
        Morphia morphia = new Morphia();
        morphia.map(Administracao.class,Alternativa.class,Auditoria.class,AvaliacaoDissertativa.class,AvaliacaoObjetiva.class,ClassificacaoGabaritoAvaliacaoDissertativa.class,ClassificacaoGabaritoAvaliacaoObjetiva.class,Documento.class,Endereco.class,Escolaridade.class,Funcionario.class,GabaritoAvaliacaoDissertativa.class,GabaritoAvaliacaoObjetiva.class,GabaritoQuestaoDissertativa.class,GabaritoQuestaoObjetiva.class,Instituicao.class,Perfil.class,Periodo.class,QuestaoDissertativa.class,QuestaoObjetiva.class,Representante.class,Status.class,Telefone.class,Token.class);
        MongoClient mongoClient = new MongoClient(addr, credential, options);
        Datastore datastore = morphia.createDatastore(mongoClient, this.mongoDatabase);
        datastore.ensureIndexes(Administracao.class);
        datastore.ensureIndexes(Alternativa.class);
        datastore.ensureIndexes(Auditoria.class);
        datastore.ensureIndexes(AvaliacaoDissertativa.class);
        datastore.ensureIndexes(AvaliacaoObjetiva.class);
        datastore.ensureIndexes(Documento.class);
        datastore.ensureIndexes(Endereco.class);
        datastore.ensureIndexes(Escolaridade.class);
        datastore.ensureIndexes(Funcionario.class);
        datastore.ensureIndexes(GabaritoQuestaoDissertativa.class);
        datastore.ensureIndexes(GabaritoQuestaoObjetiva.class);
        datastore.ensureIndexes(Instituicao.class);
        datastore.ensureIndexes(Perfil.class);
        datastore.ensureIndexes(Periodo.class);
        datastore.ensureIndexes(QuestaoDissertativa.class);
        datastore.ensureIndexes(QuestaoObjetiva.class);
        datastore.ensureIndexes(Representante.class);
        datastore.ensureIndexes(Status.class);
        datastore.ensureIndexes(Telefone.class);
        datastore.ensureIndexes(Token.class);
        datastore.getCollection(GabaritoAvaliacaoObjetiva.class).dropIndexes();
        datastore.getCollection(GabaritoAvaliacaoDissertativa.class).dropIndexes();
        datastore.getCollection(ClassificacaoGabaritoAvaliacaoDissertativa.class).dropIndexes();
        datastore.getCollection(ClassificacaoGabaritoAvaliacaoObjetiva.class).dropIndexes();
        return datastore;
    }

}
