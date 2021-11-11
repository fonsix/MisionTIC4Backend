package com.fonsix.backend.repositories;

import com.fonsix.backend.documents.Sequence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends MongoRepository<Sequence, String> {
	
}
