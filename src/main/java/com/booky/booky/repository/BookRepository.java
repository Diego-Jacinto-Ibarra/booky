package com.booky.booky.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booky.booky.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
    List<Book> findByPrice(double price);
}

