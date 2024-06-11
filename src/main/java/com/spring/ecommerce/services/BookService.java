package com.spring.ecommerce.services;

import com.spring.ecommerce.persistence.dao.BookRepository;
import com.spring.ecommerce.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {


//main event
   @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public Book updateBook(Long id, Book book) {
        Book updatedBook = bookRepository.findById(id).orElseThrow();
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }



}
