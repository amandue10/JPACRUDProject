package com.skilldistillery.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrud.entities.Book;

@Service
@Transactional
public class BookDaoImpl implements BookDAO {

@PersistenceContext
private EntityManager em;
	
	@Override
	public Book findById(int bookId) {

		
		return em.find(Book.class , bookId);
	}

	@Override
	public List<Book> findAll() {
		String jpql = "SELECT b FROM Book b";
		
		return em.createQuery(jpql, Book.class).getResultList();
	}
	
	
	
	
	

}
