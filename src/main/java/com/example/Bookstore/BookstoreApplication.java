package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		
		Book b1 = new Book("On the Road", "Jack Kerouac", 1957, "978014118", 19.90);
		Book b2 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "0316769177", 14.90);
		Book b3 = new Book("Notes from Underground", "Fyodor Dostoevsky", 1964, "067973452X", 14.90);
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
	
	};
	}
}
