package pcosee.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.GabaritoAvaliacaoObjetivaDAO;
import pcosee.exception.BusinessException;
import pcosee.model.GabaritoAvaliacaoObjetiva;
import pcosee.model.GabaritoQuestaoObjetiva;
import pcosee.model.Instituicao;
import pcosee.model.Periodo;
import pcosee.model.Status;

@Component
public class GabaritoAvaliacaoObjetivaFacade {

    @Autowired
    private GabaritoAvaliacaoObjetivaDAO gabaritoAvaliacaoObjetivaDAO;
    @Autowired
    private AlternativaFacade alternativaFacade;
    @Autowired
    private QuestaoObjetivaFacade questaoObjetivaFacade;
    @Autowired
    private AvaliacaoObjetivaFacade avaliacaoObjetivaFacade;
    @Autowired
    private PeriodoFacade periodoFacade;

    public void add(GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva) throws Exception {
        this.gabaritoAvaliacaoObjetivaDAO.add(gabaritoAvaliacaoObjetiva);
    }

    public void add(Instituicao instituicao, Periodo periodo, String[] questaoObjetiva) throws BusinessException, ParseException, Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        if (hoje.compareTo(periodo.getInicioPrimeiraFase()) < 0) {
            throw new BusinessException("Esta avaliação estará disponível para resposta apenas em " + periodo.getInicioPrimeiraFase() + ".");
        }
        GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva = new GabaritoAvaliacaoObjetiva();
        gabaritoAvaliacaoObjetiva.setPeriodo(periodo);
        gabaritoAvaliacaoObjetiva.setAvaliacaoObjetiva(this.avaliacaoObjetivaFacade.get(new ObjectId("5b8598a5862bd400dcf07fe3")));
        List<GabaritoQuestaoObjetiva> listaGabaritoQuestaoObjetiva = new ArrayList();
        int nota = 0;
        for (int i = 0; i < questaoObjetiva.length; i++) {
            String[] array = questaoObjetiva[i].split(";");
            GabaritoQuestaoObjetiva gabaritoQuestaoObjetiva = new GabaritoQuestaoObjetiva();
            gabaritoQuestaoObjetiva.setQuestaoObjetiva(this.questaoObjetivaFacade.get(new ObjectId(array[0])));
            gabaritoQuestaoObjetiva.setAlternativa(this.alternativaFacade.get(new ObjectId(array[1])));
            nota = nota + gabaritoQuestaoObjetiva.getAlternativa().getValor();
            listaGabaritoQuestaoObjetiva.add(gabaritoQuestaoObjetiva);
        }
        gabaritoAvaliacaoObjetiva.setGabaritoQuestaoObjetiva(listaGabaritoQuestaoObjetiva);
        gabaritoAvaliacaoObjetiva.setInstituicao(instituicao);
        List<Status> listaStatus = new ArrayList<>();
        Status status = new Status();
        status.setData(new Date());
        status.setStatus("Respondida");
        listaStatus.add(status);
        status = new Status();
        status.setData(new Date());
        status.setStatus("Concluída");
        listaStatus.add(status);
        gabaritoAvaliacaoObjetiva.setStatus(listaStatus);
        gabaritoAvaliacaoObjetiva.setNota(nota);
        this.gabaritoAvaliacaoObjetivaDAO.add(gabaritoAvaliacaoObjetiva);
    }

    public GabaritoAvaliacaoObjetiva get(ObjectId id) throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.get(id);
    }
    
    public GabaritoAvaliacaoObjetiva get(ObjectId id, Instituicao instituicao) throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.get(id,instituicao);
    }

    public List<GabaritoAvaliacaoObjetiva> get() throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.get();
    }

    public List<GabaritoAvaliacaoObjetiva> get(Instituicao instituicao) throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.get(instituicao);
    }

    public List<GabaritoAvaliacaoObjetiva> get(Periodo periodo) throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.get(periodo);
    }

    public List<GabaritoAvaliacaoObjetiva> getSorted(Periodo periodo) throws Exception {
        return this.gabaritoAvaliacaoObjetivaDAO.getSorted(periodo);
    }

    public List<GabaritoAvaliacaoObjetiva> list(Instituicao instituicao) throws Exception {
        List<GabaritoAvaliacaoObjetiva> listaDeGabaritoAvaliacaoObjetiva = this.get(instituicao);
        List<Periodo> listaDePeriodo = this.periodoFacade.get();
        List<Periodo> listaDePeriodoTemp = new ArrayList();
        listaDePeriodoTemp.addAll(listaDePeriodo);
        for (Periodo periodo : listaDePeriodo) {
            for (GabaritoAvaliacaoObjetiva avaliacao : listaDeGabaritoAvaliacaoObjetiva) {
                if (avaliacao.getPeriodo().getId().equals(periodo.getId())) {
                    listaDePeriodoTemp.remove(periodo);
                }
            }
        }
        if (!listaDePeriodoTemp.isEmpty()) {
            for (Periodo periodo : listaDePeriodoTemp) {
                GabaritoAvaliacaoObjetiva avaliacao = new GabaritoAvaliacaoObjetiva();
                avaliacao.setInstituicao(instituicao);
                avaliacao.setPeriodo(periodo);
                avaliacao.setNota(0);
                Status status = new Status();

                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
                Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));

                if (hoje.compareTo(periodo.getInicioPrimeiraFase()) < 0) {
                    status.setStatus("Não Iniciado");
                } else {
                    if (hoje.compareTo(periodo.getInicioSegundaFase()) > 0) {
                        status.setStatus("Não Participou");
                    } else {
                        status.setStatus("Pendente");
                    }
                }

                List<Status> listaStatusTemp = new ArrayList();
                listaStatusTemp.add(status);
                avaliacao.setStatus(listaStatusTemp);
                if (listaDeGabaritoAvaliacaoObjetiva.isEmpty()) {
                    listaDeGabaritoAvaliacaoObjetiva = new ArrayList();
                    listaDeGabaritoAvaliacaoObjetiva.add(avaliacao);
                } else {
                    listaDeGabaritoAvaliacaoObjetiva.add(avaliacao);
                }
            }
        }
        return listaDeGabaritoAvaliacaoObjetiva;
    }

    public void update(GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva) throws Exception {
        this.gabaritoAvaliacaoObjetivaDAO.update(gabaritoAvaliacaoObjetiva);
    }

}
