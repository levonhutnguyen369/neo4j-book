package com.spring.ecommerce.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Node ("Author")
@Setter
@Getter
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(generatorClass =  LongIDGenerator.class)
     private Long id;
     private String name;

     @Relationship(type = "WRITTEN")
     public Set<Book> writtenBooks;


     public void writtenBook(Optional<Book> book) {
         if (writtenBooks == null) {
             writtenBooks = new HashSet<>();
         }
         writtenBooks.add(book.get());
     }


}
