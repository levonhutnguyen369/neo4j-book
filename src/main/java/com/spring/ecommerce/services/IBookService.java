package com.spring.ecommerce.services;

import com.spring.ecommerce.persistence.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public List<Book> getAllBooks();
    public Optional<Book> getBookById(Long id);
    public Book addBook(Book book);
    public Book updateBook(Long id,Book book);
    public void deleteBook(Long id);
}
