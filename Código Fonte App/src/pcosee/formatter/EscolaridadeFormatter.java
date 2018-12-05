package pcosee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import pcosee.dao.EscolaridadeDAO;
import pcosee.model.Escolaridade;

@Component
public class EscolaridadeFormatter implements Formatter<Escolaridade> {

    @Autowired
    private EscolaridadeDAO escolaridadeDAO;

    @Override
    public String print(Escolaridade escolaridade, Locale locale) {
        return escolaridade.getId().toString();
    }

    @Override
    public Escolaridade parse(String id, Locale locale) throws ParseException {
        try {
            return this.escolaridadeDAO.get(new ObjectId(id));
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), e.hashCode());
        }
    }

}
