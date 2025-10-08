package com.example.Journal.Repository;

import com.example.Journal.Entity.ConfigJournalAppEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {
}
