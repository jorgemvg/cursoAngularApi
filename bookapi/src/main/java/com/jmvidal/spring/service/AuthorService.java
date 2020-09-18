package com.jmvidal.spring.service;

import java.util.List;

import com.jmvidal.spring.model.Author;

public interface AuthorService {

	// Save the record
	long save(Author author);

	// GEt a single record
	Author get(long id);

	// Get all the records
	List<Author> list();

	// Update the record
	void update(long id, Author author);

	// Delete a record
	void delete(long id);

	boolean exists(long id);

}
