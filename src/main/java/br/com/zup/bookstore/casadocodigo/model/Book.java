package br.com.zup.bookstore.casadocodigo.model;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateBookRequest;
import br.com.zup.bookstore.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Size(max = 500)
    private String resume;

    @NotNull
    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private int pages;

    @NotBlank
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publishDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;

    public Book(CreateBookRequest request, Author author, Category category) {
        this.title = request.getTitle();
        this.resume = request.getResume();;
        this.summary = request.getSummary();
        this.price = request.getPrice();
        this.pages = request.getPages();
        this.isbn = request.getIsbn();
        this.publishDate = request.getPublishDate();
        this.category = category;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
