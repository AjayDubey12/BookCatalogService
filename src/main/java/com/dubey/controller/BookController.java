package com.dubey.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dubey.entity.Book;
import com.dubey.service.BookService;

@RestController("BookController")
public class BookController {
	
@Autowired
private BookService bookService;


@RequestMapping(value={"/","/books"},method=RequestMethod.GET,produces="application/json")
public Collection<Book> getBooks(){
	
	return bookService.getBooks();
}

@RequestMapping(value={"/findByBookId/{bookId}"},method=RequestMethod.GET,produces="application/json")
public Book findByBookId(@PathVariable(value="bookId",required=true) Long bookId){
	
	return  bookService.getBookById(bookId);
}

@RequestMapping(value="/addBook",method=RequestMethod.POST,produces="application/json",consumes="application/json")
public Book  addBooks(@RequestBody Book book){
	
	
	return bookService.createBook(book);
}

@RequestMapping(value="/findByTitle/{title}",method=RequestMethod.GET,produces="application/json")
public Book findByTitle(@PathVariable("title") String title){
	
	return bookService.findBookByTitle(title);
}

@RequestMapping(value="/findByISBN/{isbn}",method=RequestMethod.GET,produces="application/json")
public Book findByISBN(@PathVariable("isbn") Long isbn){
	
	return bookService.findBookByISBN(isbn);
}

@RequestMapping(value="/findByAuthor/{authorId}",method=RequestMethod.GET,produces="application/json")
public Book findByAuthor(@PathVariable long  authorId){
	
	
	return bookService.findBookByAuthor(authorId);
}

@RequestMapping(value="/deleteByISBN/{isbn}",method=RequestMethod.DELETE,produces="application/json")
public Book deleteByISBN(@PathVariable("isbn") Long isbn){
	
	return bookService.deleteByISBN(isbn);
}
@RequestMapping(value="/deleteByTitle/{title}",method=RequestMethod.DELETE,produces="application/json")
public Book deleteByTitle(@PathVariable("title") String title){
	
	return bookService.deleteBookByTitle(title);
}

@RequestMapping(value="/deleteByAuthor/{authorId}",method=RequestMethod.DELETE,produces="application/json")
public Book deleteByAuthor(@PathVariable("authorId") Long authorId){
	
	return bookService.deleteBookByAuthor(authorId);
}


}
