package pcosee.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pcosee.exception.CustomException;

@Service
public class MailHelper {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendSimpleMail(String to, String subject, String message) throws CustomException {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(message);
            this.mailSender.send(email);
        } catch (Exception e) {
            throw new CustomException(e.getCause());
        }
    }

}
