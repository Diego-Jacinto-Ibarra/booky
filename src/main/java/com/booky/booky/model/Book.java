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
    private String publisher;
    private String publish_date;
    private Float price;

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
    public String getPublisher() {
        return publisher;
    }
    public String getPublish_date() {
        return publish_date;
    }
    public Float getPrice() {
        return price;
    }

}
