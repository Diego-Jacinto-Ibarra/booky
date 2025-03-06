package com.booky.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.booky.booky.service.BookService;
import com.booky.booky.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> listarProductos() {
        return bookService.getBooks();
    }
}
