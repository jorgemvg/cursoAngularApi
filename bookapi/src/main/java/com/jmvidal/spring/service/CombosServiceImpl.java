package com.jmvidal.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jmvidal.spring.model.Combo;

@Service
public class CombosServiceImpl implements CombosService{

	@Override
	@Transactional
	public List<Combo> getPaises() {
		List<Combo> lista = new ArrayList<Combo>();
		lista.add( new Combo("1","Colombia") );
		lista.add( new Combo("2","Mexico") );
		lista.add( new Combo("3","Estados Unidos") );
		return lista;
	}

	@Override
	@Transactional
	public List<Combo> getDepartamentos() {
		List<Combo> lista = new ArrayList<Combo>();
		lista.add( new Combo("1","Antioquia") );
		lista.add( new Combo("2","Quintana Roo") );
		lista.add( new Combo("3","New York") );
		return lista;
	}

	@Override
	@Transactional
	public List<Combo> getCiudades() {
		List<Combo> lista = new ArrayList<Combo>();
		lista.add( new Combo("1","Medellin") );
		lista.add( new Combo("2","Cancun") );
		lista.add( new Combo("3","New York") );
		return lista;
	}

	@Override
	@Transactional
	public List<Combo> getEstadosCiviles() {
		List<Combo> lista = new ArrayList<Combo>();
		lista.add( new Combo("1","Casado") );
		lista.add( new Combo("2","Soltero") );
		return lista;
	}

	@Override
	@Transactional
	public List<Combo> getSexos() {
		List<Combo> lista = new ArrayList<Combo>();
		lista.add( new Combo("1","Masculino") );
		lista.add( new Combo("2","Femenino") );
		return lista;
	}
	
}
