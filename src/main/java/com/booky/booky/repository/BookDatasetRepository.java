package com.booky.booky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booky.booky.model.BookDataset;

public interface BookDatasetRepository extends JpaRepository<BookDataset, String> {}

