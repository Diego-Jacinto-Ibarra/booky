package com.booky.booky.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booky.booky.model.BookDataset;
import com.booky.booky.repository.BookDatasetRepository;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookDatasetRepository bookDatasetRepository;

       public List<BookDataset> getBooks() {
        return bookDatasetRepository.findAll().stream().limit(500).toList();
    }
}
