package pcosee.facade;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcosee.dao.QuestaoObjetivaDAO;
import pcosee.model.QuestaoObjetiva;

@Component
public class QuestaoObjetivaFacade {

    @Autowired
    private QuestaoObjetivaDAO questaoObjetivaDAO;

    public void add(QuestaoObjetiva questaoObjetiva) throws Exception {
        this.questaoObjetivaDAO.add(questaoObjetiva);
    }

    public QuestaoObjetiva get(ObjectId id) throws Exception {
        return this.questaoObjetivaDAO.get(id);
    }

}
