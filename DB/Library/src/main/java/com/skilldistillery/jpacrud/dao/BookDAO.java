package com.skilldistillery.jpacrud.dao;

import java.util.List;

import com.skilldistillery.jpacrud.entities.Book;

public interface BookDAO {
	
	Book findById(int bookId);
	List<Book> findAll();
//	Book create(Book book);
	Book updateBook(int id, Book book);
	boolean deleteBook(int id);
//	Book create(Book book, int id);
	Book create(int id, Book book);

}
