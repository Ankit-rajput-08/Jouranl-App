package com.example.Journal.Repository;


import com.example.Journal.Entity.UserEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryIml {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserEntry> getAllUserSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
         List<UserEntry> users = mongoTemplate.find(query, UserEntry.class);
         return users;
    }
}
