package com.example.Journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
        return  new MongoTransactionManager(dbFactory);
    }

    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }


}


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Document(collection = "user_entries")
//public class UserEntry {
//
//    @Id
//    private ObjectId id;
//
//    @Indexed(unique = true)
//    @NonNull
//    private String userName;
//    private String email;
//    private boolean sentimentAnalysis;
//
//    @NonNull
//    private String password;
//
//    @DBRef
//    private List<JournalEntry> journalEntries = new ArrayList<>();
//
//    private List<String > Roles;
//}

//spring.data.mongodb.host = localhost
//spring.data.mongodb.port = 27017

//spring.data.mongodb.uri = mongodb+srv://Ankit:Hawan2000@cluster0.ysx5hm5.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0