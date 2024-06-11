package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Author;
import com.spring.ecommerce.persistence.model.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface AuthorRepository extends Neo4jRepository<Author, Long> {

//    public Author findByAuthor(String author);

}
