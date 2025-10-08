package com.example.Journal.Repository;

import com.example.Journal.Entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntry, ObjectId> {
    UserEntry findByUserName(String userName);
    UserEntry deleteByUserName(String userName);
}
