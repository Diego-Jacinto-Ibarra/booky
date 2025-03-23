package com.booky.booky.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booky.booky.model.Book;
import com.booky.booky.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll().stream().limit(500).toList();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByFilter(String title, double price) {
        List<Book> books = getAllBooks();

        if (title != null) {
            books = books.stream().filter(book -> book.getTitle().equals(title)).toList();
        }

        if (price != 0) {
            books = books.stream().filter(book -> book.getPrice() == price).toList();
        }

        return books;

    }

}
