package com.booky.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.booky.booky.service.BookService;
import com.booky.booky.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> listarProductos(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Double price) {

        bookService.findBooksByFilter(title, price);

        return bookService.getAllBooks();
    }
}
