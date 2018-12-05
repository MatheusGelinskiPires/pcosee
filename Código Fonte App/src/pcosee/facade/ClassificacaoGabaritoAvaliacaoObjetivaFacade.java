package pcosee.facade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.ClassificacaoGabaritoAvaliacaoObjetivaDAO;
import pcosee.helper.MailHelper;
import pcosee.model.ClassificacaoGabaritoAvaliacaoObjetiva;
import pcosee.model.GabaritoAvaliacaoObjetiva;
import pcosee.model.Periodo;
import pcosee.model.Status;

@Component
public class ClassificacaoGabaritoAvaliacaoObjetivaFacade {

    @Autowired
    private ClassificacaoGabaritoAvaliacaoObjetivaDAO classificacaoGabaritoAvaliacaoObjetivaDAO;
    @Autowired
    private PeriodoFacade periodoFacade;
    @Autowired
    private GabaritoAvaliacaoObjetivaFacade gabaritoAvaliacaoObjetivaFacade;
    @Autowired
    private MailHelper mailHelper;

    public void add(ClassificacaoGabaritoAvaliacaoObjetiva classificacaoGabaritoAvaliacaoObjetiva) throws Exception {
        this.classificacaoGabaritoAvaliacaoObjetivaDAO.add(classificacaoGabaritoAvaliacaoObjetiva);
    }

    public void delete(ClassificacaoGabaritoAvaliacaoObjetiva classificacaoGabaritoAvaliacaoObjetiva) throws Exception {
        this.classificacaoGabaritoAvaliacaoObjetivaDAO.delete(classificacaoGabaritoAvaliacaoObjetiva);
    }

    public List<ClassificacaoGabaritoAvaliacaoObjetiva> get() throws Exception {
        return this.classificacaoGabaritoAvaliacaoObjetivaDAO.get();
    }

    public ClassificacaoGabaritoAvaliacaoObjetiva get(Periodo periodo) throws Exception {
        return this.classificacaoGabaritoAvaliacaoObjetivaDAO.get(periodo);
    }

    public ClassificacaoGabaritoAvaliacaoObjetiva get(ObjectId id) throws Exception {
        ClassificacaoGabaritoAvaliacaoObjetiva classificacaoGabaritoAvaliacaoObjetiva = this.classificacaoGabaritoAvaliacaoObjetivaDAO.get(id);
        if (classificacaoGabaritoAvaliacaoObjetiva == null) {
            throw new Exception("ClassificacaoGabaritoAvaliacaoObjetiva não encontrado. ID: " + id);
        }
        return classificacaoGabaritoAvaliacaoObjetiva;
    }

    public void classify() throws Exception {
        List<Periodo> listaPeriodo = this.periodoFacade.get();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        for (Periodo periodo : listaPeriodo) {
            List<GabaritoAvaliacaoObjetiva> listaGabaritoAvaliacaoObjetiva = this.gabaritoAvaliacaoObjetivaFacade.getSorted(periodo);
            ClassificacaoGabaritoAvaliacaoObjetiva classificacaoGabaritoAvaliacaoObjetiva = this.get(periodo);
            if (classificacaoGabaritoAvaliacaoObjetiva == null) {
                if (hoje.compareTo(periodo.getInicioSegundaFase()) > 0) {
                    classificacaoGabaritoAvaliacaoObjetiva = new ClassificacaoGabaritoAvaliacaoObjetiva();
                    classificacaoGabaritoAvaliacaoObjetiva.setPeriodo(periodo);
                    classificacaoGabaritoAvaliacaoObjetiva.setGabaritoAvaliacaoObjetiva(listaGabaritoAvaliacaoObjetiva);
                    for (GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva : listaGabaritoAvaliacaoObjetiva) {
                        Status status = new Status();
                        status.setData(periodo.getInicioSegundaFase());
                        status.setStatus("Classificada");
                        gabaritoAvaliacaoObjetiva.getStatus().add(status);
                        this.gabaritoAvaliacaoObjetivaFacade.update(gabaritoAvaliacaoObjetiva);
                        this.mailHelper.sendSimpleMail(gabaritoAvaliacaoObjetiva.getInstituicao().getEmail(), "Classificação para Fase Dissertativa - PCOSEE", "Parabéns, você foi selecionado para a Fase Dissertativa - PCOSEE");
                        this.mailHelper.sendSimpleMail(gabaritoAvaliacaoObjetiva.getInstituicao().getRepresentante().getEmail(), "Classificação para Fase Dissertativa - PCOSEE", "Parabéns, você foi selecionado para a Fase Dissertativa - PCOSEE");
                    }
                    this.add(classificacaoGabaritoAvaliacaoObjetiva);
                }
            }
        }
    }
}
