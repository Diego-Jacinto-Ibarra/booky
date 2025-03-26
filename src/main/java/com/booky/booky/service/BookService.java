package com.booky.booky.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booky.booky.model.Book;
import com.booky.booky.repository.BookRepository;

import java.util.List;
import java.util.concurrent.Flow.Publisher;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll().stream().limit(5).toList();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByFilter(String title, Float price, String authors, String category, String publisher) {
        List<Book> books = getAllBooks();

        if (title == null && price == null && authors == null && category == null && publisher == null) {
            return getBooks();
        }
        if (title != null) {
            books = books.stream().filter(book -> book.getTitle().equals(title)).toList();
        }

        if (price != null) {
            books = books.stream().filter(book -> Float.compare(book.getPrice(),price)==0).toList();

        }
        if (authors != null) {
            books = books.stream().filter(book -> book.getAuthors() == authors).toList();
        }

        if (category != null) {
            books = books.stream().filter(book -> book.getCategory() == category).toList();
        }

        if (publisher != null) {
            books = books.stream().filter(book -> book.getPublisher() == publisher).toList();
        }

        if (books.size() == 0) {
            System.out.println("No books found");
            return null;

        }
        return books;

    }

}
