package com.spring.ecommerce.services;

import com.spring.ecommerce.persistence.dao.AuthorRepository;
import com.spring.ecommerce.persistence.dao.BookRepository;
import com.spring.ecommerce.persistence.model.Author;
import com.spring.ecommerce.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements  IAuthor {

    @Autowired
    public AuthorRepository authorRepository;
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = authorRepository.findById(id).get();
        updatedAuthor.setId(author.getId());
        updatedAuthor.setName(author.getName());
        return authorRepository.save(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).get();
        authorRepository.delete(author);
    }

    public Optional<Book> getBookById(Long bookID) {
        return bookRepository.findById(bookID);
    }
}
