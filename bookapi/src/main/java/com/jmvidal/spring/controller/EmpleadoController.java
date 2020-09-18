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
import com.jmvidal.spring.model.Book;
import com.jmvidal.spring.model.Empleado;
import com.jmvidal.spring.service.BookService;
import com.jmvidal.spring.service.EmpleadoService;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	//Get all the books
	@GetMapping("/api/empleado")
	public ResponseEntity<List<Empleado>> list(){
		List<Empleado> list = empleadoService.list();
		return ResponseEntity.ok().body( list );
	}

//	//Save the book
	@PostMapping( "/api/empleado" ) 
	public ResponseEntity<?> save(@RequestBody Empleado empleado){
		Gson gson = new Gson();
		long id = empleadoService.save(empleado);
		return ResponseEntity.ok().body( gson.toJson("Empelado created with id: "+ id) );
	}
//	
//	//Get book by id
	@GetMapping("/api/empleado/{id}")
	public ResponseEntity<Empleado> get(@PathVariable("id") long id ){
		Empleado empleado = empleadoService.get(id);
		return ResponseEntity.ok().body( empleado );
	}
//	
//	//Update the book
	@PutMapping( "/api/empleado/{id}" ) 
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Empleado empleado ){
		Gson gson = new Gson();
		empleadoService.update(id, empleado);
		return ResponseEntity.ok().body( gson.toJson("Empleado has been updated") );
	}
//	
	//delete a book record
	@DeleteMapping ( "/api/empleado/{id}" ) 
	public ResponseEntity<?> delete(@PathVariable("id") long id ){
		Gson gson = new Gson();
		boolean exists = true;//empleadokService.exists(id);
		
		if ( exists ) {
			empleadoService.delete(id);
			return ResponseEntity.ok().body( gson.toJson("El registro ha sido eliminado.") );
		} else {
			return ResponseEntity.badRequest().body( gson.toJson("El registro no existe.") );
		}
	}

}
