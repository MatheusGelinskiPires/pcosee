package pcosee.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pcosee.model.Telefone;

@Component
public class TelefoneConverter implements Converter<String[], List<Telefone>> {

    @Override
    public List<Telefone> convert(String[] source) {
        List<Telefone> telefones = new ArrayList<>();
        int tmp = source.length - 1;
        if (tmp > 0) {
            for (int i = 0; i < tmp; i++) {
                if (source[i] != "") {
                    Telefone telefone = new Telefone();
                    telefone.setTelefone(source[i]);
                    telefones.add(telefone);
                }
            }
        }
        return telefones;
    }

}
