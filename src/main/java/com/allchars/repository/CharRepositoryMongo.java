package com.allchars.repository;

import com.allchars.documents.CharDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharRepositoryMongo extends MongoRepository<CharDocument, String> {
}
