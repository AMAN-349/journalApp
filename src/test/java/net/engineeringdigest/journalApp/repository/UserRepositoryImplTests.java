package net.engineeringdigest.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
public class UserRepositoryImplTests {

    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser()
    {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }

}
