package com.mymind.journalApplication.Repository;

import com.mymind.journalApplication.entity.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<Journal, String> {
}
