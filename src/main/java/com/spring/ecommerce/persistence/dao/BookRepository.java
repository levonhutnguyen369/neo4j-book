package com.spring.ecommerce.persistence.dao;

import com.spring.ecommerce.persistence.model.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends Neo4jRepository<Book, Long>
{
    public Book findByName(String bookName);
}
