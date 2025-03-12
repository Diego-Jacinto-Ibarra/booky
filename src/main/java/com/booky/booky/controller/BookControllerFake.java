package com.booky.booky.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookControllerFake {

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBooks(String title, String author, String description, String category, String publisher,
            String publish_date, Integer price) {
        return "{ \"title\": \"" + title + "\", \"author\": \"" + author + "\", \"description\": \""
                + description + "\", \"category\": \"" + category + "\", \"publisher\": \"" + publisher
                + "\", \"publish_date\": \"" + publish_date + "\", \"price\": " + price + " }";
    }

    @PutMapping("/books")
    public String updateBooks(String title, String author, String description, String category, String publisher,
            String publish_date, Integer price) {
        return "{ \"title\": \"" + title + "\", \"author\": \"" + author + "\", \"description\": \""
                + description + "\", \"category\": \"" + category + "\", \"publisher\": \"" + publisher
                + "\", \"publish_date\": \"" + publish_date + "\", \"price\": " + price + " }";
    }

    @DeleteMapping("/books")
    public String deleteBooks(Integer id) {
        return "{ \"id\": " + id + " }";
    }

}
