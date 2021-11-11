package com.fonsix.backend.services;

import java.util.Optional;

import com.fonsix.backend.documents.Sequence;
import com.fonsix.backend.repositories.SequenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

	@Autowired
	private SequenceRepository sequenceRepository;

	public Integer next(String document) {
		Sequence sequence;
		Optional<Sequence> optionalSequence = sequenceRepository.findById(document);
		if (optionalSequence.isPresent()) {
			sequence = optionalSequence.get();
			sequence.increment();
		} else {
			sequence = new Sequence(document, 1);
		}
		sequenceRepository.save(sequence);
		return sequence.getValue();
	}

}
