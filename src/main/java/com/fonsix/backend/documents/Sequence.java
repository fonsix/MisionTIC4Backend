package com.fonsix.backend.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sequence implements Serializable {

	@Id
	private String id;
	private Integer value;

	public Sequence() {

	}

	public Sequence(String id, Integer value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer increment() {
		return ++value;
	}

}
