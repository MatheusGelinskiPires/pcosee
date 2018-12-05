package pcosee.helper;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import pcosee.model.Token;

@Component
public class TokenHelper {

    @Autowired
    private MailHelper mailHelper;
    @Autowired
    private CacheManager cacheManager;

    public void enviaToken(String email) throws Exception {
        UUID uuid = UUID.randomUUID();
        Token token = new Token();
        token.setToken(uuid.toString());
        token.setEmail(email);
        this.cacheManager.getCache("Token").put(token.getToken(), token);
        mailHelper.sendSimpleMail(email, "Token PCOSEE", "Token: " + token.getToken());
    }

    public void validaToken(String token, String email) throws Exception {
        try {
            Token tk = (Token) this.cacheManager.getCache("Token").get(token).get();
            if (!tk.getEmail().equals(email)) {
                throw new Exception("Token inválido!");
            }
        } catch (NullPointerException e) {
            throw new Exception("Token expirado!");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
