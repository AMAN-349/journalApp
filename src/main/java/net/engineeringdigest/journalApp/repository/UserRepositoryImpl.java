package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

//here we we not user repository use criteria for retreival of data
//to implement criteria query is used
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate; //a class provided by spring data mongodb by this we interact with db

    //here we want user who have sentimental field as true
    public List<User> getUserForSA()
    {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        );
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        List<User> users = mongoTemplate.find(query,User.class);  //we pass class it find collections from it
        return users;
    }

}


// Some imp things
//        Criteria criteria = new Criteria();
//        query.addCriteria(criteria.orOperator(Criteria.where("email").exists(true),
//                Criteria.where("sentimentAnalysis").is(true)));
//        or condition

//        query.addCriteria(Criteria.where("email").exists(true));  //check field is present
//        query.addCriteria(Criteria.where("email").ne(null).ne(""));
//
//play with array also with in or not in values