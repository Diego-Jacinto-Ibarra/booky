package com.booky.booky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booky.booky.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {}

