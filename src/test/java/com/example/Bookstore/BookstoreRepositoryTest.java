package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	
	@Autowired
	private BookRepository bRepo;
	@Autowired
	private CategoryRepository cRepo;
	@Autowired
	private UserRepository uRepo;
	
	@Test
	public void bookTests() {
		//save
		Book book = new Book("aaa", "aaa", 1234, "1234a", 1.9, cRepo.findByName("Classics").get(0));
		bRepo.save(book);
		assertThat(book.getId()).isNotNull();
		//find
		List<Book> books = bRepo.findByAuthor("aaa");
		assertThat(books.get(0).getAuthor()).isEqualTo("aaa");
		//delete
		bRepo.delete(book);
		assertThat(bRepo.findById(book.getId())).isEmpty();
	}
	
	@Test
	public void categoryTests() {
		//save
		Category category = new Category("test");
		cRepo.save(category);
		assertThat(category.getId()).isNotNull();
		//find
		List<Category> categories = cRepo.findByName("test");
		assertThat(categories.get(0).getName()).isEqualTo("test");
		//delete
		cRepo.delete(category);
		assertThat(cRepo.findById(category.getId())).isEmpty();
	}
	
	@Test
	public void userTests() {
		//save
		User user = new User("dummy", "dumbpassword", "idiotboy@dumbmail.com", "USER");
		uRepo.save(user);
		assertThat(user.getId()).isNotNull();
		//find
		User users = uRepo.findByUsername("dummy");
		assertThat(users.getUsername()).isEqualTo("dummy");
		//delete
		uRepo.delete(user);
		assertThat(uRepo.findById(user.getId())).isEmpty();
		
	}

}
