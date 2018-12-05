package pcosee.helper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TipsHelper {

    public String generatePassword() {
        SecureRandom random = new SecureRandom();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";
        String password = "";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(chars.length());
            password += chars.charAt(index);
        }
        return password;
    }

    public String hashMD5Password(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Erro";
        }
    }

    public String dateStr(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String str = fmt.format(date);
        return str;
    }

    public float floatRound(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
