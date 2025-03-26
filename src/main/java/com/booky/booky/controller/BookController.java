package com.booky.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.booky.booky.service.BookService;

import com.booky.booky.model.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> listarProductos(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) String authors,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String publisher){


        return bookService.findBooksByFilter(title, price,authors,category,publisher);
    }
}
