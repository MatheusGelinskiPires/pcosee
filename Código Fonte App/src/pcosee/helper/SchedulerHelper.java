/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcosee.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import pcosee.facade.ClassificacaoGabaritoAvaliacaoDissertativaFacade;
import pcosee.facade.ClassificacaoGabaritoAvaliacaoObjetivaFacade;

@Configuration
public class SchedulerHelper {

    @Autowired
    private ClassificacaoGabaritoAvaliacaoObjetivaFacade classificacaoGabaritoAvaliacaoObjetivaFacade;
    @Autowired
    private ClassificacaoGabaritoAvaliacaoDissertativaFacade classificacaoGabaritoAvaliacaoDissertativaFacade;

    @Scheduled(fixedDelay = 10000)
    public void doClassificacaoGabaritoAvaliacaoObjetiva() {
        try {
        this.classificacaoGabaritoAvaliacaoObjetivaFacade.classify();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Scheduled(fixedDelay = 10000)
    public void doEndPeriodoAvaliacaoDissertativa() {
        try {
        this.classificacaoGabaritoAvaliacaoDissertativaFacade.endPeriodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Scheduled(fixedDelay = 10000)
    public void doClassificacaoGabaritoAvaliacaoDissertativa() {
        try {
        this.classificacaoGabaritoAvaliacaoDissertativaFacade.classify();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
