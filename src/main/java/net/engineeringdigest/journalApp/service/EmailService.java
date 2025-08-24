//package net.engineeringdigest.journalApp.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class EmailService {
//    //java provides interface it implemented automatically we just give some configuration in app.yml
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//    //it is null if no conf. in app.yml after it bean is injected here by spring
//
//    public void sendEmail(String to, String subject, String body)
//    {
//        try{
//            SimpleMailMessage mail = new SimpleMailMessage();
//            mail.setTo(to);
//            mail.setSubject(subject);
//            mail.setText(body);
//            javaMailSender.send(mail);
//        } catch (Exception e) {
//            log.error("Exception while send email ",e);
//        }
//    }
//}
