package com.mymind.journalApplication.controller;

import com.mymind.journalApplication.Service.JournalService;
import com.mymind.journalApplication.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public String createJournal(@RequestBody Journal journal){
        journal.setDate(LocalDateTime.now());
        journalService.createJournal(journal);
        return "Journal Entry Created!";
    }

    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> journals = journalService.getAllJournals();
        if(journals != null && !journals.isEmpty()){
            return new ResponseEntity<>(journals, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable ObjectId id){
        Journal journal1 = journalService.getJournalById(id).orElse(null);
        return new ResponseEntity<>(journal1, HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public String deleteJournal(@PathVariable ObjectId id){
        return journalService.deleteJournalById(id);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<Journal> updateJournalEntry(@PathVariable ObjectId id, @RequestBody Journal journal){
        Journal oldJournal = journalService.getJournalById(id).orElse(null);

        if(oldJournal != null){
            oldJournal.setTitle(journal.getTitle() != null && !journal.getTitle().equals("")? journal.getTitle() : oldJournal.getTitle());
            oldJournal.setContent(journal.getContent() != null && !journal.getContent().equals("") ? journal.getContent() : oldJournal.getContent());
        }
        journalService.createJournal(oldJournal);
        return new ResponseEntity<>(oldJournal, HttpStatus.OK);
    }


}
