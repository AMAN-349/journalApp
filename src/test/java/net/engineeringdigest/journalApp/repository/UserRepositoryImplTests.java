package net.engineeringdigest.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@DataMongoTest
public class UserRepositoryImplTests {

    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser()
    {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }

}
