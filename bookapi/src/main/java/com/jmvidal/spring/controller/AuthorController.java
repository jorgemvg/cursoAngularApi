package com.jmvidal.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jmvidal.spring.model.Author;
import com.jmvidal.spring.service.AuthorService;

@CrossOrigin("*")
@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	//Get all the authors
	@GetMapping("/api/author")
	public ResponseEntity<List<Author>> list(){
		List<Author> list = authorService.list();
		return ResponseEntity.ok().body( list );
	}

	//Save the author
	@PostMapping( "/api/author" ) 
	public ResponseEntity<?> save(@RequestBody Author author ){
		Gson gson = new Gson();
		long id = authorService.save(author);
		return ResponseEntity.ok().body( gson.toJson("Author created with id: "+ id) );
	}
	
	//Get author by id
	@GetMapping("/api/author/{id}")
	public ResponseEntity<Author> get(@PathVariable("id") long id ){
		Author author = authorService.get(id);
		return ResponseEntity.ok().body( author );
	}
	
	//Update the author
	@PutMapping( "/api/author/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Author author ){
		Gson gson = new Gson();
		authorService.update(id, author);
		return ResponseEntity.ok().body( gson.toJson("Author has been updated") );
	}
	
	//delete a author record
	@DeleteMapping ( "/api/author/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		boolean exists = authorService.exists(id);
		
		if ( exists ) {
			authorService.delete(id);
			return ResponseEntity.ok().body( gson.toJson("Author has been deleted") );
		} else {
			return ResponseEntity.badRequest().body( gson.toJson("The author doesn't exist.") );
		}
	}

}
