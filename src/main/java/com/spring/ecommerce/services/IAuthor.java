package com.spring.ecommerce.services;

import com.spring.ecommerce.persistence.model.Author;

import java.util.List;

public interface IAuthor {
   public List<Author> getAllAuthors();
   public Author getAuthorById(Long id);
   public Author addAuthor(Author author);
   public Author updateAuthor(Long id, Author author);
   public void deleteAuthor(Long id);


}
