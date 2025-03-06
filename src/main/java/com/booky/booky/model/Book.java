package com.booky.booky.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "booksdataset_clean")
@Immutable
public class Book {
    @Id
    private String title;
    private String authors;
    private String description;
    private String category;
    private String pubisher;
    private String publish_date;
    private String price;

    public Book() {
    }

    public String getTitle() {
        return title;
    }
    public String getAuthors() {
        return authors;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public String getPubisher() {
        return pubisher;
    }
    public String getPublish_date() {
        return publish_date;
    }
    public String getPrice() {
        return price;
    }

}
