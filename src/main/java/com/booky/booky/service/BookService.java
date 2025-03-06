package com.booky.booky.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booky.booky.model.Book;
import com.booky.booky.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookDatasetRepository;

    public List<Book> getBooks() {
        return bookDatasetRepository.findAll().stream().limit(500).toList();
    }
}
