package com.jmvidal.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmvidal.spring.dao.AuthorDAO;
import com.jmvidal.spring.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDAO authorDao;
	
	@Override
	@Transactional
	public long save(Author author) {
		return authorDao.save(author);
	}

	@Override
	@Transactional
	public Author get(long id) {
		return authorDao.get(id);
	}

	@Override
	@Transactional
	public List<Author> list() {
		return authorDao.list();
	}

	@Override
	@Transactional
	public void update(long id, Author author) {
		authorDao.update(id, author);
	}

	@Override
	@Transactional
	public void delete(long id) {
		authorDao.delete(id);
	}
	
	@Override
	@Transactional
	public boolean exists(long id) {
		return authorDao.exists(id);
	}

}