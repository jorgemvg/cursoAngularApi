package com.jmvidal.spring.dao;

import java.util.List;

import com.jmvidal.spring.model.Book;

public interface BookDAO {

	//Save the record
	long save( Book book );
	
	//GEt a single record
	Book get(long id);
	
	//Get all the records
	List<Book> list();
	
	//Update the record
	void update( long id, Book book );
	
	//Delete a record
	void delete(long id);

	boolean exists(long id);
	
}
