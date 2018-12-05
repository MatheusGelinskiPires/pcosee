package pcosee.facade;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.AvaliacaoObjetivaDAO;
import pcosee.exception.BusinessException;
import pcosee.exception.CustomException;
import pcosee.model.AvaliacaoObjetiva;
import pcosee.model.Periodo;

@Component
public class AvaliacaoObjetivaFacade {

    @Autowired
    private AvaliacaoObjetivaDAO avaliacaoObjetivaDAO;

    public void add(AvaliacaoObjetiva avaliacaoObjetiva) throws Exception {
        this.avaliacaoObjetivaDAO.add(avaliacaoObjetiva);
    }

    public AvaliacaoObjetiva get(ObjectId id, Periodo periodo) throws BusinessException, CustomException {

        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
            if (hoje.compareTo(periodo.getInicioPrimeiraFase()) < 0) {
                throw new BusinessException("Esta avaliação estará disponível para resposta apenas em " + periodo.getInicioPrimeiraFase() + ".");
            }
            return this.avaliacaoObjetivaDAO.get(id);
        } catch (Exception e) {
            throw new CustomException(e);
        }
    }
    
    public AvaliacaoObjetiva get(ObjectId id) throws BusinessException, CustomException {
        try {
            return this.avaliacaoObjetivaDAO.get(id);
        } catch (Exception e) {
            throw new CustomException(e);
        }
    }

}
