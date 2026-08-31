// service Calls Repository
package com.example._3_journalApp.service;

import com.example._3_journalApp.entity.JournalEntry;
import com.example._3_journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JournalEntryRepository journalEntryRepository;     // bean

    public void saveEntry(JournalEntry journalEntry) {

        System.out.println("Database BEFORE: " + mongoTemplate.getDb().getName());

        journalEntryRepository.save(journalEntry);

        System.out.println("Database AFTER: " + mongoTemplate.getDb().getName());
        System.out.println("Collections: " + mongoTemplate.getCollectionNames());
    }

//    public void saveEntry(JournalEntry journalEntry) {
//
//        System.out.println("BEFORE SAVE");
//        System.out.println("Title: " + journalEntry.getTitle());
//        System.out.println("Content: " + journalEntry.getContent());
//
//        JournalEntry saved = journalEntryRepository.save(journalEntry);
//
//        System.out.println("AFTER SAVE");
//        System.out.println("Generated ID: " + saved.getId());
//    }

    //====================== MAIN one to keep==================
//    public void saveEntry(JournalEntry journalEntry){
//        journalEntryRepository.save(journalEntry);
//    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
