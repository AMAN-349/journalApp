package net.engineeringdigest.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory)
    {
        return new MongoTransactionManager(dbFactory); //this is actual implemetation of platformtransactionmanager
    }
    //by mark method bean the return object stores in IOC
    //here MongoDatabaseFactory also a interface which is implemented automatically by spring boot by app. properties
    //implementation in mongoclientdatabase factory

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
    //create instance and injected into weatherservice

}