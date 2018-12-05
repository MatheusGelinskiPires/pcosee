package pcosee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import pcosee.dao.PerfilDAO;
import pcosee.model.Perfil;

@Component
public class PerfilFormatter implements Formatter<Perfil> {

    @Autowired
    private PerfilDAO perfilDAO;

    @Override
    public String print(Perfil perfil, Locale locale) {
        return perfil.getId().toString();
    }

    @Override
    public Perfil parse(String id, Locale locale) throws ParseException {
        try {
            return this.perfilDAO.get(new ObjectId(id));
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), e.hashCode());
        }
    }

}
