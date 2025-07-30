package com.mymind.journalApplication.Service;

import com.mymind.journalApplication.Repository.JournalRepository;
import com.mymind.journalApplication.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public void createJournal(Journal journal) {
        journalRepository.save(journal);
    }


    @Override
    public Optional<Journal> getJournalById(ObjectId id) {
        return journalRepository.findById(String.valueOf(id));
    }

    @Override
    public String deleteJournalById(ObjectId id) {
        journalRepository.deleteById(String.valueOf(id));
        return "Journal Entry deleted!";
    }

    @Override
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }


}
