package com.dubey.BookCatalogService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.dubey.BookCatalogServiceApplication;
import com.dubey.entity.Author;
import com.dubey.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookCatalogServiceApplication.class)
@WebAppConfiguration
public class BookControllerTest extends BaseTestClass {

	@Before
	public void contextLoads() {
		super.setUp();
	}

	@Test
	public void createBookTest() throws Exception {
     //testing post call
		String uri="/addBook";
		Book book=new Book(10L, 777L, "SPringboot", "Springboot framework Tutorials",
				new Author(10L, "James", "Gosling"));
		String inputJson = super.mapToJson(book);
		this.mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
		
		
		
	}

	@Test
	public void findByIDTest() throws Exception {
		String uri = "/findByBookId/{bookId}";
		Long bookId = 2L;
		this.mvc.perform(MockMvcRequestBuilders.get(uri, bookId).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void findByISBNTest() throws Exception {
		String uri = "/findByISBN/{isbn}";
		Long isbn = 222L;
		this.mvc.perform(MockMvcRequestBuilders.get(uri, isbn).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void findByTitleTest() throws Exception {
		String uri = "/findByTitle/{title}";
		String title = "The Java Programming Language";
		this.mvc.perform(MockMvcRequestBuilders.get(uri, title).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void findByBookAuthorTest() throws Exception {
		String uri = "/findByAuthor/{authorId}";
		Long authorId = 1L;
		this.mvc.perform(MockMvcRequestBuilders.get(uri, authorId).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	// ignoring as it will delete book
	@Ignore
	public void deleteBookByAuthorTest() throws Exception {
		String uri = "/deleteByAuthor/{authorId}";
		Long authorId = 1L;
		this.mvc.perform(MockMvcRequestBuilders.delete(uri, authorId).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	// ignoring as it will delete book

	@Ignore
	public void deleteBookByISBNTest() throws Exception {
		String uri = "/deleteByISBN/{isbn}";
		Long isbn = 222L;
		this.mvc.perform(MockMvcRequestBuilders.delete(uri, isbn).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	// ignoring as it will delete book
	@Ignore
	public void deleteBookByTitleTest() throws Exception {
		String uri = "/deleteByTitle/{title}";
		String title = "The Java Programming Language";
		this.mvc.perform(MockMvcRequestBuilders.delete(uri, title).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
}
