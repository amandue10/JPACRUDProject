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
		
		@RequestMapping(path = "create.do", method=RequestMethod.GET)
		public String create(@RequestParam("id") int id,
				@RequestParam("title") String title,
				@RequestParam("author") String author, 
				@RequestParam("description") String description, 
				@RequestParam("publishedDate") Date publishedDate,
				@RequestParam("totalPages") String totalPages,
				@RequestParam("genre") String genre, 
				@RequestParam("isbn") String isbn,
				Model model) {
			String success = "success";
			String fail= "fail";
			
			Book b = new Book();
			b.setId(id);
			b.setTitle(title);
			b.setAuthor(author);
			b.setDescription(description);
			b.setPublishedDate(publishedDate);
			b.setTotalPages(totalPages);
			b.setGenre(genre);
			b.setIsbn(isbn);
			
			Book dbBook = dao.create(b);
			model.addAttribute("book", b);
			if(dbBook.getId() > 0) {
				return success;
			} else {
			
			return fail;
		}
		
		}
	}
	

