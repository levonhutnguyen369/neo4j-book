package com.spring.ecommerce.controller;


import com.spring.ecommerce.persistence.dao.BookRepository;
import com.spring.ecommerce.persistence.model.Author;
import com.spring.ecommerce.persistence.model.Book;
import com.spring.ecommerce.services.AuthorService;
import com.spring.ecommerce.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class AuthorController {
    @Autowired
    public AuthorService authorService;
//    public BookService bookService;


    @GetMapping("/getAllAuthor")
    public ResponseEntity <List<Author>> getAllAuthor() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/getAuthorByID/{authorID}")
    public ResponseEntity<Author> getAuthorByID(@PathVariable("authorID") Long authorID) {
        Author author = authorService.getAuthorById(authorID);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }


    @PostMapping ("/addAuthor")
    public ResponseEntity<Author> addAuthor( @RequestBody Author author) {
         Author saveAuthor= authorService.addAuthor(author);
         return new ResponseEntity<>(saveAuthor, HttpStatus.OK);
    }


    @PostMapping ("/addAuthor/{bookID}")
    public ResponseEntity<Author> addAuthor (@RequestBody Author author, @PathVariable Long bookID) {
        Optional<Book> book = authorService.getBookById(bookID);
        author.writtenBook(book);
        Author saveAuthor;
        saveAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(saveAuthor, HttpStatus.OK);
    }


    @PostMapping("/addAllAuthor")
    public ResponseEntity<List<Author>> addAllAuthor( @RequestBody List<Author> authors) {
        authors.forEach( author -> {
            authorService.addAuthor(author);
        });
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("/updateAuthor/{authorID}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("authorID") Long authorID, @RequestBody Author author) {
        Author newAuthor = authorService.getAuthorById(authorID);
        newAuthor.setId(author.getId());
        newAuthor.setName(author.getName());
        authorService.updateAuthor(authorID, author);
        return new ResponseEntity<>(newAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/delateAuthor/{authorID}")
    public ResponseEntity<Author> delateAuthor(@PathVariable("authorID") Long authorID) {
        Author author = authorService.getAuthorById(authorID);
        authorService.deleteAuthor(authorID);
        return new ResponseEntity<>(author, HttpStatus.OK);

    }
}
