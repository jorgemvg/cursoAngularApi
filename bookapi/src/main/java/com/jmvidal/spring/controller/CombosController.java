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
import com.jmvidal.spring.model.Combo;
import com.jmvidal.spring.model.Empleado;
import com.jmvidal.spring.service.BookService;
import com.jmvidal.spring.service.CombosService;
import com.jmvidal.spring.service.EmpleadoService;

@CrossOrigin("http://localhost:4200")
@RestController
public class CombosController {

	@Autowired
	private CombosService combosService;
	
	@GetMapping("/api/combos/paises")
	public ResponseEntity<List<Combo>> getPaises(){
		List<Combo> list = combosService.getPaises();
		return ResponseEntity.ok().body( list );
	}

	@GetMapping("/api/combos/dptos")
	public ResponseEntity<List<Combo>> getDepartamentos(){
		List<Combo> list = combosService.getDepartamentos();
		return ResponseEntity.ok().body( list );
	}

	@GetMapping("/api/combos/ciudades")
	public ResponseEntity<List<Combo>> getCiudades(){
		List<Combo> list = combosService.getCiudades();
		return ResponseEntity.ok().body( list );
	}

	@GetMapping("/api/combos/estadosCiviles")
	public ResponseEntity<List<Combo>> getEstadosCiviles(){
		List<Combo> list = combosService.getEstadosCiviles();
		return ResponseEntity.ok().body( list );
	}
	
	@GetMapping("/api/combos/sexos")
	public ResponseEntity<List<Combo>> getSexos(){
		List<Combo> list = combosService.getSexos();
		return ResponseEntity.ok().body( list );
	}
}
