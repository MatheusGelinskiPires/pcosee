package pcosee.facade;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.ClassificacaoGabaritoAvaliacaoDissertativaDAO;
import pcosee.helper.MailHelper;
import pcosee.model.ClassificacaoGabaritoAvaliacaoDissertativa;
import pcosee.model.GabaritoAvaliacaoDissertativa;
import pcosee.model.Periodo;
import pcosee.model.Status;

@Component
public class ClassificacaoGabaritoAvaliacaoDissertativaFacade {

    @Autowired
    private ClassificacaoGabaritoAvaliacaoDissertativaDAO classificacaoGabaritoAvaliacaoDissertativaDAO;
    @Autowired
    private PeriodoFacade periodoFacade;
    @Autowired
    private GabaritoAvaliacaoDissertativaFacade gabaritoAvaliacaoDissertativaFacade;
    @Autowired
    private MailHelper mailHelper;

    public void add(ClassificacaoGabaritoAvaliacaoDissertativa classificacaoGabaritoAvaliacaoDissertativa) throws Exception {
        this.classificacaoGabaritoAvaliacaoDissertativaDAO.add(classificacaoGabaritoAvaliacaoDissertativa);
    }

    public void delete(ClassificacaoGabaritoAvaliacaoDissertativa classificacaoGabaritoAvaliacaoDissertativa) throws Exception {
        this.classificacaoGabaritoAvaliacaoDissertativaDAO.delete(classificacaoGabaritoAvaliacaoDissertativa);
    }

    public List<ClassificacaoGabaritoAvaliacaoDissertativa> get() throws Exception {
        return this.classificacaoGabaritoAvaliacaoDissertativaDAO.get();
    }

    public ClassificacaoGabaritoAvaliacaoDissertativa get(Periodo periodo) throws Exception {
        return this.classificacaoGabaritoAvaliacaoDissertativaDAO.get(periodo);
    }

    public ClassificacaoGabaritoAvaliacaoDissertativa get(ObjectId id) throws Exception {
        ClassificacaoGabaritoAvaliacaoDissertativa classificacaoGabaritoAvaliacaoDissertativa = this.classificacaoGabaritoAvaliacaoDissertativaDAO.get(id);
        if (classificacaoGabaritoAvaliacaoDissertativa == null) {
            throw new Exception("ClassificacaoGabaritoAvaliacaoDissertativa não encontrado. ID: " + id);
        }
        return classificacaoGabaritoAvaliacaoDissertativa;
    }

    public void endPeriodo() throws Exception {
        List<Periodo> listaPeriodo = this.periodoFacade.get();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        for (Periodo periodo : listaPeriodo) {
            List<GabaritoAvaliacaoDissertativa> listaGabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.get(periodo);
            ClassificacaoGabaritoAvaliacaoDissertativa classificacaoGabaritoAvaliacaoDissertativa = this.get(periodo);
            if (classificacaoGabaritoAvaliacaoDissertativa == null) {
                if (hoje.compareTo(periodo.getFim()) > 0) {
                    classificacaoGabaritoAvaliacaoDissertativa = new ClassificacaoGabaritoAvaliacaoDissertativa();
                    classificacaoGabaritoAvaliacaoDissertativa.setPeriodo(periodo);
                    classificacaoGabaritoAvaliacaoDissertativa.setGabaritoAvaliacaoDissertativa(listaGabaritoAvaliacaoDissertativa);
                    for (GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa : listaGabaritoAvaliacaoDissertativa) {
                        boolean control = false;
                        for (Status status : gabaritoAvaliacaoDissertativa.getStatus()) {
                            if (status.getStatus().equals("Aguardando Auditoria") || status.getStatus().equals("Finalizada")) {
                                control = true;
                            }
                        }
                        if (!control) {
                            Status status = new Status();
                            status.setData(periodo.getFim());
                            status.setStatus("Concluída");
                            gabaritoAvaliacaoDissertativa.getStatus().add(status);
                            status = new Status();
                            status.setData(new Date());
                            status.setStatus("Aguardando Auditoria");
                            gabaritoAvaliacaoDissertativa.getStatus().add(status);
                            this.gabaritoAvaliacaoDissertativaFacade.update(gabaritoAvaliacaoDissertativa);
                            this.mailHelper.sendSimpleMail(gabaritoAvaliacaoDissertativa.getInstituicao().getEmail(), "Início do período de auditorias - Fase Dissertativa - PCOSEE", "A partir de " + periodo.getFim() + "começa o período de auditoria reference ä fase Dissertativa do PCOSEE.");
                            this.mailHelper.sendSimpleMail(gabaritoAvaliacaoDissertativa.getInstituicao().getRepresentante().getEmail(), "Início do período de auditorias - Fase Dissertativa - PCOSEE", "A partir de " + periodo.getFim() + "começa o período de auditoria reference ä fase Dissertativa do PCOSEE.");
                        }
                    }
                }
            }
        }
    }

    public void classify() throws Exception {
        List<Periodo> listaPeriodo = this.periodoFacade.get();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        Status status = new Status();
        status.setStatus("Finalizada");
        for (Periodo periodo : listaPeriodo) {
            List<GabaritoAvaliacaoDissertativa> listaGabaritoAvaliacaoDissertativa = this.gabaritoAvaliacaoDissertativaFacade.getNotEqual(periodo, status);
            ClassificacaoGabaritoAvaliacaoDissertativa classificacaoGabaritoAvaliacaoDissertativa = this.get(periodo);
            if (classificacaoGabaritoAvaliacaoDissertativa == null && !listaGabaritoAvaliacaoDissertativa.isEmpty()) {
                Date fimAuditoria = periodo.getFim();
                Calendar c = Calendar.getInstance();
                c.setTime(fimAuditoria);
                c.add(Calendar.DATE, 10);
                fimAuditoria = dateFormatter.parse(dateFormatter.format(c.getTime()));
                if (hoje.compareTo(fimAuditoria) > 0) {
                    for (GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa : listaGabaritoAvaliacaoDissertativa) {
                        status = new Status();
                        status.setStatus("Finalizada");
                        status.setData(new Date());
                        gabaritoAvaliacaoDissertativa.getStatus().add(status);
                        this.gabaritoAvaliacaoDissertativaFacade.update(gabaritoAvaliacaoDissertativa);
                    }
                    classificacaoGabaritoAvaliacaoDissertativa = new ClassificacaoGabaritoAvaliacaoDissertativa();
                    classificacaoGabaritoAvaliacaoDissertativa.setPeriodo(periodo);
                    classificacaoGabaritoAvaliacaoDissertativa.setGabaritoAvaliacaoDissertativa(this.gabaritoAvaliacaoDissertativaFacade.getSorted(periodo));
                    if (classificacaoGabaritoAvaliacaoDissertativa.getGabaritoAvaliacaoDissertativa() != null) {
                        for (GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa : classificacaoGabaritoAvaliacaoDissertativa.getGabaritoAvaliacaoDissertativa()) {
                            status = new Status();
                            status.setStatus("Classificada");
                            status.setData(new Date());
                            gabaritoAvaliacaoDissertativa.getStatus().add(status);
                            this.gabaritoAvaliacaoDissertativaFacade.update(gabaritoAvaliacaoDissertativa);
                            this.mailHelper.sendSimpleMail(gabaritoAvaliacaoDissertativa.getInstituicao().getEmail(), "PCOSEE - Classificação Fase Apresentativa", "Parabéns, a sua intituição foi selecionada para a fase Apresentativa do PCOSEE!.");
                            this.mailHelper.sendSimpleMail(gabaritoAvaliacaoDissertativa.getInstituicao().getRepresentante().getEmail(), "PCOSEE - Classificação Fase Apresentativa", "Parabéns, a sua intituição foi selecionada para a fase Apresentativa do PCOSEE!.");
                        }
                    }
                    this.add(classificacaoGabaritoAvaliacaoDissertativa);
                }
            }
        }
    }

}
