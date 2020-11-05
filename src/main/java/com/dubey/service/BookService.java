package com.dubey.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.dubey.entity.Author;
import com.dubey.entity.Book;
import com.dubey.exception.BookNotFoundException;

@Service
public class BookService {

	static Map<Long, Book> bookTempDataMap = new HashMap<Long, Book>();
	static long bookIdCnt = 0;
	static {

		bookTempDataMap.put(getBookIdCount(), new Book(bookIdCnt, 111L, "Java", "The Java Programming Language",
				new Author(bookIdCnt, "James", "Gosling")));
		bookTempDataMap.put(getBookIdCount(), new Book(bookIdCnt, 222L, "Data Structure", "Data Structure concept",
				new Author(bookIdCnt, "Narasimha", "Karumanchi")));
		bookTempDataMap.put(getBookIdCount(),
				new Book(bookIdCnt, 333L, "RDMS", "The Relational database", new Author(bookIdCnt, "Nishant", "")));
		bookTempDataMap.put(getBookIdCount(), new Book(bookIdCnt, 444L, "C", "The C Programming Language",
				new Author(bookIdCnt, "Dennis", "Ritchie")));
		bookTempDataMap.put(getBookIdCount(), new Book(bookIdCnt, 555L, "C++", "The C++ Programming Language",
				new Author(bookIdCnt, "Bjarne", "Stroustrup")));
		bookTempDataMap.put(getBookIdCount(), new Book(bookIdCnt, 666L, "SPringboot", "Springboot framework Tutorials",
				new Author(bookIdCnt, "James", "Gosling")));

	}

	public static long getBookIdCount() {
		;
		return ++bookIdCnt;
	}

	public Collection<Book> getBooks() {
		return bookTempDataMap.values();
	}
	
	
	public Book createBook(Book book) {
		Book existingBook=null;
		if(book.getId()!=null){
	   existingBook=getBookById(book.getId());
		}
		if (existingBook != null) {
		return	updateBook(book);
		}
		else  {
				// create new book
				bookIdCnt =getBookIdCount();
				book.setId(bookIdCnt);
				if(book.getAuthor()!=null){
				book.getAuthor().setId(bookIdCnt);
				}
				bookTempDataMap.put(bookIdCnt, book);
			} 
			
		
		return getBookById(book.getId());
	}

	public Book updateBook(Book book) {

		Book bookDB = null;

		if (book != null && book.getId() > 0) {
			// update book
			bookDB = getBookById(book.getId());

			bookDB.setName(StringUtils.isEmpty(book.getName()) ? "" : book.getName());

			bookDB.setTitle(StringUtils.isEmpty(book.getTitle()) ? "" : book.getTitle());
			bookDB.setAuthor(new Author(book.getId(),
					StringUtils.isEmpty(book.getAuthor().getFirstName()) ? "" : book.getAuthor().getFirstName(),
					StringUtils.isEmpty(book.getAuthor().getLastName()) ? "" : book.getAuthor().getLastName()));

			bookTempDataMap.put(bookDB.getId(), bookDB);
		}
		return getBookById(book.getId());
	}

	public Book getBookById(Long id) {
		Optional<Book> book = bookTempDataMap.entrySet().stream().filter(e -> e.getValue().getId() == id.longValue())
				.map(e -> e.getValue()).findAny();
		return book.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
	}
	
	
	public Book findBookByTitle(String title) {
		Optional<Book> book = getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findAny();
		return book.orElseThrow(() -> new BookNotFoundException("Book not found with Title: " + title));

	}
	

	public Book findBookByISBN(Long isbn) {

		Optional<Book> book = getBooks().stream().filter(b -> b.getIsbn().longValue() == isbn.longValue()).findAny();
		return book.orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
	}

	public Book findBookByAuthor(Long authorId) {
	
		return getBookById(authorId);

	}

	
	

	public Book deleteByISBN(Long isbn) {

		return deleteBookById(findBookByISBN(isbn).getId());

	}

	public Book deleteBookByTitle(String title) {

		return deleteBookById(findBookByTitle(title).getId());

	}

	public Book deleteBookByAuthor(Long authorId) {

		return deleteBookById(findBookByAuthor(authorId).getId());

	}

	public Book deleteBookById(Long id) {
		Book book = getBookById(id);
		return bookTempDataMap.remove(book.getId());

	}

}
