package br.com.zup.bookstore.casadocodigo.controller.response;

import br.com.zup.bookstore.casadocodigo.model.Book;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetailedBookResponse {

    private String title;

    private String resume;

    private String summary;

    private BigDecimal price;

    private int pages;

    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publishDate;

    private AuthorResponse author;

    private CategoryResponse category;

    public DetailedBookResponse(Book book) {
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pages = book.getPages();
        this.isbn = book.getIsbn();
        this.publishDate = book.getPublishDate();
        this.author = new AuthorResponse(book.getAuthor());
        this.category = new CategoryResponse(book.getCategory());
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

    public AuthorResponse getAuthor() {
        return author;
    }

    public CategoryResponse getCategory() {
        return category;
    }
}
