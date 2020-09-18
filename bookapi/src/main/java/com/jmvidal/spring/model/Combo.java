package com.jmvidal.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Combo")
public class Combo {
	@Id
	private String id;
	private String descripcion;

	public Combo(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
