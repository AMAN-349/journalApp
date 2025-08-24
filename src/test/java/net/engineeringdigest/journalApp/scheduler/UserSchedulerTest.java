package net.engineeringdigest.journalApp.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;


@SpringBootTest
public class UserSchedulerTest {

    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void testFetchUserAndSendSAEmail()
    {
        userScheduler.fetchUsersAndSendSaMail();
    }
}
