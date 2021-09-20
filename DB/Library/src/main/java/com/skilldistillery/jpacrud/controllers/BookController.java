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
		
		
		
		@RequestMapping(path = "create.do")
		public String bookForm() {
			return "create";
			
		}
//--------------------------------------------------------------------------------------------------------------------------------			
			
			@RequestMapping(path = "remove.do")
			public String removeBook(int id, Model model) {
				boolean result = dao.deleteBook(id);
						
				if (result == true) {
					return"success";
				} else {
					return "fail";
				}
			}
				
				@RequestMapping(path = "edit.do", method=RequestMethod.GET)
				public String editBook(@RequestParam int id, Model model) {
					String viewName = "edit";
					Book book = dao.findById(id);
					model.addAttribute("book", book);
					model.addAttribute("id", id);
					return viewName;
				}
				
				@RequestMapping(path="edit.do", method=RequestMethod.POST, params="book")
				public String editForm(Book book, @RequestParam("id") int id, Model model) {
					
					
					String viewName = "home";
						dao.updateBook(id, book);
					
					return viewName;
				}
		
		}
	
	

