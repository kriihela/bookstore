package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/booklist")
	public String getBook(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}
