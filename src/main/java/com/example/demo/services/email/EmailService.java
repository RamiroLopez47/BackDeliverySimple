package com.example.demo.services.email;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    @Autowired
    private JavaMailSender emailSender;
    /*
    @Autowired
    private MailSender mailSenderSimple;
*/
    @Value("${spring.mail.username}@gmail.com")
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean enviarEmail(String destinatario, String asunto, String mensaje, String nombreArchivo,String idFactura)
            throws MessagingException 
    {
    
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject(asunto);
        helper.setText(mensaje+"\n"+         
        "http://localhost:9001/api/v1/pdf/test/?idFactura="+idFactura);
        helper.setTo(destinatario);
        helper.setFrom(from);
        if(!nombreArchivo.equals("no")){
            FileSystemResource file  = new FileSystemResource(new File(nombreArchivo));
            helper.addAttachment("testfile.jpg", file);
    
    
            file  = new FileSystemResource(new File("src/main/java/com/example/demo/chau.jpg"));
            helper.addAttachment("auxiliar.jpg", file);
        }
      
     

try{
    emailSender.send(message);
    return true;
}catch(Exception e){

}
return false;
        
        
    }

    /*
    public boolean enviarEmail(String destinatario, String asunto, String mensaje) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(mensaje);

        try {
            mailSenderSimple.send(simpleMailMessage);

            return true;
        } catch (Exception e) {

        }
        return false;
    }
*/
}