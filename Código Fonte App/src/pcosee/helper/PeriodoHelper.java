/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcosee.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pcosee.facade.PeriodoFacade;
import pcosee.model.Periodo;

@Service
public class PeriodoHelper {

    @Autowired
    private PeriodoFacade periodoFacade;

    public boolean isEmPercurso() throws Exception {
        boolean controle = false;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date hoje = dateFormatter.parse(dateFormatter.format(new Date()));
        List<Periodo> listaPeriodo = this.periodoFacade.get();
        for (Periodo periodo : listaPeriodo) {
            if (hoje.compareTo(periodo.getInicioPrimeiraFase()) >= 0 && hoje.compareTo(periodo.getFim()) <= 0) {
                controle=true;
            }
        }
        return controle;
    }

}
