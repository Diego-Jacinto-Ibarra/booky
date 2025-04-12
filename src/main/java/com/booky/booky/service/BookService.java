package com.booky.booky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.text.similarity.LevenshteinDistance;

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
            LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
            final int MAX_DISTANCE = 3;
            books = books.stream()
                    .filter(book -> levenshteinDistance.apply(book.getTitle().toLowerCase(),
                            title.toLowerCase()) <= MAX_DISTANCE)
                    .toList();
        }

        if (price != null) {
            books = books.stream().filter(book -> Float.compare(book.getPrice(), price) == 0).toList();

        }
        if (authors != null) {
            books = books.stream().filter(book -> book.getAuthors().equals(authors)).toList();
        }

        if (category != null) {
            books = books.stream().filter(book -> {
                String[] categories = book.getCategory().split(","); // Separar las categorías
                for (String cat : categories) {
                    if (cat.trim().equalsIgnoreCase(category)) { // Comparar ignorando mayúsculas/minúsculas
                        return true;
                    }
                }
                return false;
            })
            .toList();
            
        }

        if (publisher != null) {
            books = books.stream().filter(book -> book.getPublisher().equals(publisher)).toList();
        }

        if (books.size() == 0) {
            System.out.println("No books found");
            return null;

        }
        return books;

    }

}
