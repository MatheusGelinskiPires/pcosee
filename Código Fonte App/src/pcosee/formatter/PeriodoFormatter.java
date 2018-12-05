package pcosee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import pcosee.dao.PeriodoDAO;
import pcosee.model.Periodo;

@Component
public class PeriodoFormatter implements Formatter<Periodo> {

    @Autowired
    private PeriodoDAO periodoDAO;

    @Override
    public String print(Periodo periodo, Locale locale) {
        return periodo.getId().toString();
    }

    @Override
    public Periodo parse(String id, Locale locale) throws ParseException {
        try {
            return this.periodoDAO.get(new ObjectId(id));
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), e.hashCode());
        }
    }

}
