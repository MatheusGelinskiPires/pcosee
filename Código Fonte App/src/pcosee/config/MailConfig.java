/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcosee.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    
    @Value("${mail.host}")
    private String mailHost;
    @Value("${mail.port}")
    private String mailPort;
    @Value("${mail.user}")
    private String mailUser;
    @Value("${mail.pass}")
    private String mailPass;
    @Value("${mail.protocol}")
    private String mailProtocol;
    @Value("${mail.auth}")
    private String mailAuth;
    @Value("${mail.ssl}")
    private String mailSSL;
    @Value("${mail.debug}")
    private String mailDebug;

    @Bean
    public JavaMailSender mailSender() {
    
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.mailHost);
        mailSender.setPort(Integer.parseInt(this.mailPort));
        mailSender.setUsername(this.mailUser);
        mailSender.setPassword(this.mailPass);
        Properties emailProperties = mailSender.getJavaMailProperties();
        emailProperties.put("mail.transport.protocol", this.mailProtocol);
        emailProperties.put("mail.smtp.auth", this.mailAuth);
        emailProperties.put("mail.smtp.starttls.enable", this.mailSSL);
        emailProperties.put("mail.debug", this.mailDebug);
        mailSender.setJavaMailProperties(emailProperties);
        return mailSender;
    }
    
    
}
