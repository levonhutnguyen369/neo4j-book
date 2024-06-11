package com.spring.ecommerce.controller;

import  com.spring.ecommerce.persistence.model.Book;
import com.spring.ecommerce.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity <List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/getBookByID/{bookID}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable("bookID") Long bookID) {

        return new ResponseEntity<>(bookService.getBookById(bookID), HttpStatus.OK);
    }


    /* add a new book*/
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }


    @PostMapping ( "/addAllBooks")
    public ResponseEntity<List<Book>> addAllBooks(@RequestBody List<Book> books) {
        books.forEach(book -> {
            bookService.addBook(book);
        });
        return new ResponseEntity<>( books,HttpStatus.OK);
    }

    @PutMapping("/updateBook/{bookID}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookID, @RequestBody Book book) {
        Book savedBook = bookService.updateBook(bookID, book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    //dang bug
    @DeleteMapping("deleteBook/{bookID}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long bookID) {
        bookService.deleteBook(bookID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
