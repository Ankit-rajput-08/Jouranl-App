package com.example.Journal.Service;

import com.example.Journal.Entity.JournalEntry;
import com.example.Journal.Entity.UserEntry;
import com.example.Journal.Repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
    public class JournalService {

        @Autowired
        private JournalRepository journalRepository;
        @Autowired
        private UserService userService;

        @Transactional
        public void saveEntry(JournalEntry journalEntry, String userName){
            try {
                UserEntry userEntry = userService.findByUserName(userName);
                journalEntry.setDate(LocalDateTime.now());
                JournalEntry saved = journalRepository.save(journalEntry);
                userEntry.getJournalEntries().add(saved);
                userService.saveUser(userEntry);
            }catch (Exception e){
                System.out.println("Exception"+e);
                throw new RuntimeException("exception");

            }
        }

    public void saveEntry(JournalEntry journalEntry){
            journalRepository.save(journalEntry);
    }

        public List<JournalEntry> getAll(){
            return journalRepository.findAll();
        }

        public Optional<JournalEntry> getById(ObjectId id){
            return journalRepository.findById(id);
        }

        @Transactional
        public boolean deleteById(ObjectId id,String userName){
            boolean removed = false;
            try {
                UserEntry userEntry = userService.findByUserName(userName);
                 removed = userEntry.getJournalEntries().removeIf(x -> x.getId().equals(id));
                if(removed) {
                    userService.saveUser(userEntry);
                    journalRepository.deleteById(id);
                }
            }catch (Exception e){
                System.out.println("Exception"+e);
                throw new RuntimeException("exception");
            }
            return removed;
        }
    }

