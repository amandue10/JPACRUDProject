package com.skilldistillery.jpacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	}
	

