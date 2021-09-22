package com.skilldistillery.jpacrud.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpacrud.dao.BookDAO;
import com.skilldistillery.jpacrud.entities.Book;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;
	
	@RequestMapping(path = {"/" , "home.do"})
	public String home(Model model) {
		model.addAttribute("book", dao.findAll());
		return "home";
	}
		@RequestMapping(path = "getBook.do")
		public String showBook(int bid, Model model) {
			Book book = dao.findById(bid);
			model.addAttribute("book", book);
			return "book/show";
			
		}
		
		
		
		@RequestMapping(path = "create.do", method = RequestMethod.POST)
		public String createBook(Book book, int id,  Model model) {
			String viewName = "create";
			Book addBook = new Book();
				addBook=dao.create(id, book);
			model.addAttribute("book", addBook);
			
			
			return viewName;
			
		}
		
//		@RequestMapping(path="create.do")
//		public String bookForm() {
//			return "create"	;
//		}
//--------------------------------------------------------------------------------------------------------------------------------			
			
			@RequestMapping(path = "remove.do")
			public String removeBook(int id, Model model) {
				boolean result = dao.deleteBook(id);
				
				if (result == true) {
					return"success";
				} else {
					return "fail";  //error happens at else stmt, trying to delete null
				}
			}
				
				@RequestMapping(path = "edit.do", method=RequestMethod.POST)
				public String editBook(Book book,int id, Model model) {
					String viewName = "edit";
					Book dbBook = dao.updateBook(id,book);
					model.addAttribute("book", dbBook);
					return viewName;
				}
				
				
		
		}
	
	

