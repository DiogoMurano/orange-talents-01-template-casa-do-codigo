package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateBookRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.BookResponse;
import br.com.zup.bookstore.casadocodigo.controller.response.DetailedBookResponse;
import br.com.zup.bookstore.casadocodigo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<DetailedBookResponse> createNewBook(@RequestBody @Valid CreateBookRequest request) {
        return ResponseEntity.ok(bookService.createNewBook(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DetailedBookResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping
    public List<BookResponse> listAllBooks() {
        return bookService.listAllBooks();
    }

}
