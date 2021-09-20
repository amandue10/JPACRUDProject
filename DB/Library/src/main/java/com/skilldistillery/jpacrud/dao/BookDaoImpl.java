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
	

	
	@Override
	public Book create(Book book) {
		System.out.println(book);
		em.persist(book);
		em.flush();
		
		System.out.println(book);
		return book;
	}
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------
	@Override
	public Book updateBook(int id, Book book) {
		Book dbBook = em.find(Book.class, id);
		
		dbBook.setId(book.getId());
		dbBook.setTitle(book.getTitle());
		dbBook.setAuthor(book.getAuthor());
		dbBook.setDescription(book.getDescription());
		dbBook.setPublishedDate(book.getPublishedDate());
		dbBook.setTotalPages(book.getTotalPages());
		dbBook.setGenre(book.getGenre());
		dbBook.setIsbn(book.getIsbn());
		
		em.flush();

		return dbBook;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean result = false;
		Book book = em.find(Book.class, id);
		em.remove(book);
		
		book = em.find(Book.class, id);
		result = ! em.contains(book);
		
				
		return result;
	}
	
	
	

}
