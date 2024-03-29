package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		log.info("save a couple of categories");
		Category c1 = new Category("Classics");
		Category c2 = new Category("Fantasy");
		Category c3 = new Category("Science fiction");
		Category c4 = new Category("Thriller");
		
		crepository.save(c1);
		crepository.save(c2);
		crepository.save(c3);
		crepository.save(c4);
		
		log.info("save a couple of books");
		Book b1 = new Book("On the Road", "Jack Kerouac", 1957, "978014118", 19.90, c1);
		Book b2 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "0316769177", 14.90, c1);
		Book b3 = new Book("Notes from Underground", "Fyodor Dostoevsky", 1864, "067973452X", 14.90, c1);
		
		brepository.save(b1);
		brepository.save(b2);
		brepository.save(b3);
		
		User u1 = new User("user", "$2a$10$mbkWZR/HwemhVPXdkn4/WeWCxSZ70yih9EJ3oEN/bW1FgtvXAvkf2", "user@user.com", "USER");
		User u2 = new User("admin", "$2a$10$XPsvcJftpuxKF7tq6Tv79u/40KVYpwaF1VY.7zmw.wgwGSQHE2CBm", "admin@admin.com", "ADMIN");
		
		urepository.save(u1);
		urepository.save(u2);
		
		
		log.info("fetch all books");
		for (Book book : brepository.findAll()) {
			log.info(book.toString());
		}
			
			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}

		
	
	};
	}
}
