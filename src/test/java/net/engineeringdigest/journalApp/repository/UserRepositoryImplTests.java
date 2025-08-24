package net.engineeringdigest.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "mongodb+srv://amantyagi3491:ifUwKFeyQm4t6OVg@cluster0.yf0hkgp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
})
public class UserRepositoryImplTests {

    @Autowired
    UserRepositoryImpl userRepository;

    @Disabled
    @Test
    public void testSaveNewUser()
    {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }

}
