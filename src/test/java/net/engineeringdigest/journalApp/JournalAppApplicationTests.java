package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.cache.AppCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class JournalAppApplicationTests {

    @MockBean
    private JavaMailSender javaMailSender;

	@Test
	void contextLoads() {
	}

}
