package pcosee.facade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.PeriodoDAO;
import pcosee.exception.BusinessException;
import pcosee.model.Periodo;

@Component
public class PeriodoFacade {

    @Autowired
    private PeriodoDAO periodoDAO;

    public void add(Periodo periodo) throws Exception {
        this.periodoDAO.add(periodo);
    }

    public void delete(Periodo periodo) throws BusinessException, Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        if (hoje.compareTo(periodo.getInicioPrimeiraFase()) > 0) {
            throw new BusinessException("Não é possível excluir um período que já foi iniciado.");
        }
        this.periodoDAO.delete(periodo);
    }

    public List<Periodo> get() throws Exception {
        return this.periodoDAO.get();
    }

    public Periodo get(ObjectId id) throws Exception {
        Periodo periodo = periodoDAO.get(id);
        if (periodo == null) {
            throw new Exception("Período não encontrado. ID: " + id);
        }
        return periodo;
    }

}
