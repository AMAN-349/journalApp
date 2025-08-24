package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("dev") //here dev config runs
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;
    //without running spring it is null as spring creates bean of it then it injected

    @ParameterizedTest
    @Disabled
    @ValueSource(strings = {
            "ram",
            "aman",
            "shyam"
    })
    public void testFindByUserName(String name)
    {
        assertNotNull(userRepository.findByuserName(name),"failed for: "+ name);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6"
    })
    public void test(int a, int b, int expected)
    {
        assertEquals(expected, a+b);
    }
}
