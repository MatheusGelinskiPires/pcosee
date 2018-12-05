package pcosee.model;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class GabaritoQuestaoObjetiva {

    @Reference
    private QuestaoObjetiva questaoObjetiva;
    @Reference
    private Alternativa alternativa;

    public QuestaoObjetiva getQuestaoObjetiva() {
        return questaoObjetiva;
    }

    public void setQuestaoObjetiva(QuestaoObjetiva questaoObjetiva) {
        this.questaoObjetiva = questaoObjetiva;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

}
