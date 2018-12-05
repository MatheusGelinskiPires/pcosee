package pcosee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import pcosee.dao.AdministracaoDAO;
import pcosee.model.Administracao;

@Component
public class AdministracaoFormatter implements Formatter<Administracao> {

    @Autowired
    private AdministracaoDAO administracaoDAO;

    @Override
    public String print(Administracao administracao, Locale locale) {
        return administracao.getId().toString();
    }

    @Override
    public Administracao parse(String id, Locale locale) throws ParseException {
        try {
            return this.administracaoDAO.get(new ObjectId(id));
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), e.hashCode());
        }
    }

}
