package com.jmvidal.spring.service;

import java.util.List;

import com.jmvidal.spring.model.Empleado;

public interface EmpleadoService {

//	// Save the record
	long save(Empleado author);
//
//	// GEt a single record
	Empleado get(long id);
//
	List<Empleado> list();
//
//	// Update the record
	void update(long id, Empleado empleado);
//
	void delete(long id);
//
//	boolean exists(long id);

}