package com.jmvidal.spring.service;

import java.util.List;

import com.jmvidal.spring.model.Combo;

public interface CombosService {

	List<Combo> getPaises();
	List<Combo> getDepartamentos();
	List<Combo> getCiudades();
	List<Combo> getEstadosCiviles();
	List<Combo> getSexos();

	
}
