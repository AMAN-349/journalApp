package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailServiceTests {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired EmailService emailService;

    @Test
    void testSendMail()
    {
        emailService.sendEmail("sbhinavtyagi349@gmail.com","Testing java mail sender","Hi, how are you?");
    }
}
