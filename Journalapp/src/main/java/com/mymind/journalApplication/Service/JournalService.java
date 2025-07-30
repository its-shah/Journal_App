package com.mymind.journalApplication.Service;

import com.mymind.journalApplication.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface JournalService {
    void createJournal(Journal journal);

    Optional<Journal> getJournalById(ObjectId id);

    String deleteJournalById(ObjectId id);

    List<Journal> getAllJournals();
}
