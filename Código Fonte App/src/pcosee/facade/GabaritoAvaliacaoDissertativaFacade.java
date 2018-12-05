package pcosee.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.GabaritoAvaliacaoDissertativaDAO;
import pcosee.exception.BusinessException;
import pcosee.helper.TipsHelper;
import pcosee.model.Auditoria;
import pcosee.model.ClassificacaoGabaritoAvaliacaoObjetiva;
import pcosee.model.Documento;
import pcosee.model.GabaritoAvaliacaoDissertativa;
import pcosee.model.GabaritoAvaliacaoObjetiva;
import pcosee.model.GabaritoQuestaoDissertativa;
import pcosee.model.Instituicao;
import pcosee.model.Periodo;
import pcosee.model.Funcionario;
import pcosee.model.QuestaoDissertativa;
import pcosee.model.Status;

@Component
public class GabaritoAvaliacaoDissertativaFacade {

    @Autowired
    private GabaritoAvaliacaoDissertativaDAO gabaritoAvaliacaoDissertativaDAO;
    @Autowired
    private PeriodoFacade periodoFacade;
    @Autowired
    private ClassificacaoGabaritoAvaliacaoObjetivaFacade classificacaoGabaritoAvaliacaoObjetivaFacade;
    @Autowired
    private AvaliacaoDissertativaFacade avaliacaoDissertativaFacade;
    @Autowired
    private QuestaoDissertativaFacade questaoDissertativaFacade;
    @Autowired
    private TipsHelper tipsHelper;
    @Autowired
    GabaritoAvaliacaoObjetivaFacade gabaritoAvaliacaoObjetivaFacade;

    public void add(GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa) throws Exception {
        this.gabaritoAvaliacaoDissertativaDAO.add(gabaritoAvaliacaoDissertativa);
    }

    public void add(Instituicao instituicao, Periodo periodo, Documento documento, HttpServletRequest request) throws Exception {
        GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = new GabaritoAvaliacaoDissertativa();
        gabaritoAvaliacaoDissertativa.setPeriodo(periodo);
        gabaritoAvaliacaoDissertativa.setAvaliacaoDissertativa(this.avaliacaoDissertativaFacade.get(new ObjectId("5b85a34e862bd400dccaa736")));
        gabaritoAvaliacaoDissertativa.setDocumento(documento);
        List<GabaritoQuestaoDissertativa> listaGabaritoQuestaoDissertativa = new ArrayList();
        for (QuestaoDissertativa questaoDissertativa : gabaritoAvaliacaoDissertativa.getAvaliacaoDissertativa().getQuestaoDissertativa()) {
            GabaritoQuestaoDissertativa gabaritoQuestaoDissertativa = new GabaritoQuestaoDissertativa();
            gabaritoQuestaoDissertativa.setQuestaoDissertativa(this.questaoDissertativaFacade.get(questaoDissertativa.getId()));
            gabaritoQuestaoDissertativa.setResposta(request.getParameter(questaoDissertativa.getId().toString()));
            listaGabaritoQuestaoDissertativa.add(gabaritoQuestaoDissertativa);
        }
        gabaritoAvaliacaoDissertativa.setGabaritoQuestaoDissertativa(listaGabaritoQuestaoDissertativa);
        gabaritoAvaliacaoDissertativa.setInstituicao(instituicao);
        List<Status> listaStatus = new ArrayList<>();
        Status status = new Status();
        status.setData(new Date());
        status.setStatus("Respondida");
        listaStatus.add(status);
        gabaritoAvaliacaoDissertativa.setStatus(listaStatus);
        this.add(gabaritoAvaliacaoDissertativa);
    }

    public void audit(String id, Funcionario funcionario, HttpServletRequest request) throws Exception {
        GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = this.get(new ObjectId(id));
        int count = 0;
        for (Status status : gabaritoAvaliacaoDissertativa.getStatus()) {
            if (status.getStatus().equals("Finalizada")) {
                throw new BusinessException("Esta avaliação já está finalizada.");
            }
            if (status.getStatus().equals("Auditada")) {
                count++;
            }
        }
        if (count == 3) {
            throw new BusinessException("Esta avaliação já possui 3 auditorias.");
        } else {
            for (GabaritoQuestaoDissertativa gabaritoQuestaoDissertativa : gabaritoAvaliacaoDissertativa.getGabaritoQuestaoDissertativa()) {
                if (gabaritoQuestaoDissertativa.getAuditoria() != null) {
                    for (Auditoria auditoria : gabaritoQuestaoDissertativa.getAuditoria()) {
                        if (auditoria.getFuncionario().getId().toString().equals(funcionario.getId().toString())) {
                            throw new BusinessException("Você já auditou esta avaliação.");
                        }
                    }
                }
            }

            for (GabaritoQuestaoDissertativa gabaritoQuestaoDissertativa : gabaritoAvaliacaoDissertativa.getGabaritoQuestaoDissertativa()) {
                Auditoria auditoria = new Auditoria();
                auditoria.setData(new Date());
                auditoria.setFuncionario(funcionario);
                auditoria.setNota(Integer.parseInt(request.getParameter(gabaritoQuestaoDissertativa.getQuestaoDissertativa().getId().toString())));
                if (count == 0) {
                    gabaritoQuestaoDissertativa.setAuditoria(new ArrayList<>());
                }
                gabaritoQuestaoDissertativa.getAuditoria().add(auditoria);
            }

            Status status = new Status();
            status.setData(new Date());
            status.setStatus("Auditada");
            gabaritoAvaliacaoDissertativa.getStatus().add(status);
            count++;
            if (count <= 2) {
                status = new Status();
                status.setData(new Date());
                status.setStatus("Aguardando Auditoria");
                gabaritoAvaliacaoDissertativa.getStatus().add(status);
            } else {
                status = new Status();
                status.setData(new Date());
                status.setStatus("Aguardando Classificação");
                gabaritoAvaliacaoDissertativa.getStatus().add(status);
                float nota = 0;
                for (GabaritoQuestaoDissertativa gabaritoQuestaoDissertativa : gabaritoAvaliacaoDissertativa.getGabaritoQuestaoDissertativa()) {
                    for (Auditoria auditoria : gabaritoQuestaoDissertativa.getAuditoria()) {
                        nota = nota + auditoria.getNota();
                    }
                }
                gabaritoAvaliacaoDissertativa.setNota(this.tipsHelper.floatRound(nota / 3, 2));
            }
            this.update(gabaritoAvaliacaoDissertativa);
        }
    }

    public GabaritoAvaliacaoDissertativa get(ObjectId id) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get(id);
    }

    public List<GabaritoAvaliacaoDissertativa> get(Funcionario funcionario) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get(funcionario);
    }

    public GabaritoAvaliacaoDissertativa get(ObjectId id, Funcionario funcionario) throws Exception {
        GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa = this.get(id);
        int count = 0;
        for (Status status : gabaritoAvaliacaoDissertativa.getStatus()) {
            if (status.getStatus().equals("Finalizada")) {
                throw new BusinessException("Esta avaliação já está finalizada.");
            }
            if (status.getStatus().equals("Auditada")) {
                count++;
            }
        }
        if (count == 3) {
            throw new BusinessException("Esta avaliação já possui 3 auditorias.");
        } else {
            for (GabaritoQuestaoDissertativa gabaritoQuestaoDissertativa : gabaritoAvaliacaoDissertativa.getGabaritoQuestaoDissertativa()) {
                if (gabaritoQuestaoDissertativa.getAuditoria() != null) {
                    for (Auditoria auditoria : gabaritoQuestaoDissertativa.getAuditoria()) {
                        if (auditoria.getFuncionario().getId().toString().equals(funcionario.getId().toString())) {
                            throw new BusinessException("Você já auditou esta avaliação.");
                        }
                    }
                }
            }
        }
        return gabaritoAvaliacaoDissertativa;
    }

    public List<GabaritoAvaliacaoDissertativa> get() throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get();
    }

    public List<GabaritoAvaliacaoDissertativa> get(Instituicao instituicao) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get(instituicao);
    }

    public List<GabaritoAvaliacaoDissertativa> get(Instituicao instituicao, Status status) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get(instituicao, status);
    }

    public List<GabaritoAvaliacaoDissertativa> get(Periodo periodo) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.get(periodo);
    }

    public List<GabaritoAvaliacaoDissertativa> getNotEqual(Periodo periodo, Status status) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.getNotEqual(periodo, status);
    }

    public List<GabaritoAvaliacaoDissertativa> getSorted(Periodo periodo) throws Exception {
        return this.gabaritoAvaliacaoDissertativaDAO.getSorted(periodo);
    }

    public List<GabaritoAvaliacaoDissertativa> list(Instituicao instituicao) throws Exception {
        List<GabaritoAvaliacaoDissertativa> listaDeGabaritoAvaliacaoDissertativa = this.get(instituicao);
        List<Periodo> listaDePeriodo = this.periodoFacade.get();
        List<Periodo> listaDePeriodoTemp = new ArrayList();
        listaDePeriodoTemp.addAll(listaDePeriodo);
        for (Periodo periodo : listaDePeriodo) {
            for (GabaritoAvaliacaoDissertativa avaliacao : listaDeGabaritoAvaliacaoDissertativa) {
                if (avaliacao.getPeriodo().getId().equals(periodo.getId())) {
                    listaDePeriodoTemp.remove(periodo);
                }
            }
        }
        if (!listaDePeriodoTemp.isEmpty()) {
            for (Periodo periodo : listaDePeriodoTemp) {
                GabaritoAvaliacaoDissertativa avaliacao = new GabaritoAvaliacaoDissertativa();
                avaliacao.setInstituicao(instituicao);
                avaliacao.setPeriodo(periodo);
                avaliacao.setNota(0);
                Status status = new Status();
                ClassificacaoGabaritoAvaliacaoObjetiva classificacaoGabaritoAvaliacaoObjetiva = this.classificacaoGabaritoAvaliacaoObjetivaFacade.get(periodo);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
                Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
                List<Status> listaStatusTemp = new ArrayList();
                if (classificacaoGabaritoAvaliacaoObjetiva != null) {
                    for (GabaritoAvaliacaoObjetiva gabaritoAvaliacaoObjetiva : classificacaoGabaritoAvaliacaoObjetiva.getGabaritoAvaliacaoObjetiva()) {
                        if (gabaritoAvaliacaoObjetiva.getInstituicao().getId().equals(instituicao.getId()) && hoje.compareTo(periodo.getFim()) > 0) {
                            status.setStatus("Não Participou");
                            listaStatusTemp.add(status);
                            avaliacao.setStatus(listaStatusTemp);
                            listaDeGabaritoAvaliacaoDissertativa.add(avaliacao);
                        }
                        if (gabaritoAvaliacaoObjetiva.getInstituicao().getId().equals(instituicao.getId()) && hoje.compareTo(periodo.getFim()) <= 0) {
                            status.setStatus("Pendente");
                            listaStatusTemp.add(status);
                            avaliacao.setStatus(listaStatusTemp);
                            listaDeGabaritoAvaliacaoDissertativa.add(avaliacao);
                        }
                    }
                }
            }
            return listaDeGabaritoAvaliacaoDissertativa;
        }
        return listaDeGabaritoAvaliacaoDissertativa;
    }

    public void update(GabaritoAvaliacaoDissertativa gabaritoAvaliacaoDissertativa) throws Exception {
        this.gabaritoAvaliacaoDissertativaDAO.update(gabaritoAvaliacaoDissertativa);
    }

}
