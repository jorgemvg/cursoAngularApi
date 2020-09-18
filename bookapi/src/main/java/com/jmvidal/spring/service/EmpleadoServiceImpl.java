package com.jmvidal.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmvidal.spring.dao.AuthorDAO;
import com.jmvidal.spring.model.Author;
import com.jmvidal.spring.model.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	
	
	@Override
	@Transactional
	public List<Empleado> list() {
		
//		List<Empleado> empleados = new ArrayList<Empleado>();
		
		if (empleados == null || empleados.isEmpty()) { 
		
			Empleado empleado = new Empleado();
			
			empleado.setId( new Long("1"));
			empleado.setNombres("Alejandra");
			empleado.setApellidos("Sepulveda");
			empleado.setEdad("34");
			empleados.add(empleado);
			
			empleado = new Empleado();
			empleado.setId( new Long("2"));
			empleado.setNombres("Aura");
			empleado.setApellidos("Vidal");
			empleado.setEdad("1");
			empleados.add(empleado);
			
			empleado = new Empleado();
			empleado.setId( new Long("3"));
			empleado.setNombres("Jorge");
			empleado.setApellidos("Vidal");
			empleado.setEdad("38");
			empleados.add(empleado);
			
			empleado = new Empleado();
			empleado.setId( new Long("4"));
			empleado.setNombres("Son");
			empleado.setApellidos("Goku");
			empleado.setEdad("25");
			empleados.add(empleado);
		}
		return empleados;
		
//		return authorDao.list();
		
	}
	
//	@Autowired
//	private AuthorDAO authorDao;
//	
	@Override
	@Transactional
	public long save(Empleado empleado) {
//		return authorDao.save(author);
		empleado.setId( new Long( empleados.size() ) );
		empleados.add(empleado);
		return 0;
	}
//
	@Override
	@Transactional
	public Empleado get(long id) {
		return empleados.get((int)id);
//		return authorDao.get(id);
	}
//

//
	@Override
	@Transactional
	public void update(long id, Empleado empleado) {
		empleados.add((int)id - 1, empleado);
		empleados.remove((int) id);
		//authorDao.update(id, author);
	}
//
	@Override
	@Transactional
	public void delete(long id) {
		empleados.remove( (int)id );
		System.out.println("Se elimino el registro :" + (int)id);
//		authorDao.delete(id);
	}
//	
//	@Override
//	@Transactional
//	public boolean exists(long id) {
//		return authorDao.exists(id);
//	}

}
