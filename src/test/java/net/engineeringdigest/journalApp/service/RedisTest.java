package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @MockBean
    private JavaMailSender javaMailSender;

    @Disabled
    @Test
    void testSendMail()
    {
        redisTemplate.opsForValue().set("email","smantyagi349@gmail.com");  //used for set
        Object salary = redisTemplate.opsForValue().get("salary");
        int a=1;

    }
}
