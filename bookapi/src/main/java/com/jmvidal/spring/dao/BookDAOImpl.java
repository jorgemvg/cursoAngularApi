package com.jmvidal.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jmvidal.spring.model.Book;

@Repository
public class BookDAOImpl implements BookDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> list() {

		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		
		return list;
	}

	@Override
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

	@Override
	public boolean exists( long id ) {

		boolean exists = false;
		Object object = sessionFactory.getCurrentSession().createQuery("select count(1) from Book where id = :id")
				.setParameter("id", id)
				.uniqueResult();
		
		if ( object != null ) {
			long count = (Long)object;
			if (count > 0 ) exists = true;
		}
		
		return exists;
	}
	
}
