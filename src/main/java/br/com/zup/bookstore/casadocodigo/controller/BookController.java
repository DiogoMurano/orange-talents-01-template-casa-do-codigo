package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateBookRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.BookResponse;
import br.com.zup.bookstore.casadocodigo.model.Author;
import br.com.zup.bookstore.casadocodigo.model.Book;
import br.com.zup.bookstore.casadocodigo.model.Category;
import br.com.zup.bookstore.casadocodigo.repository.AuthorRepository;
import br.com.zup.bookstore.casadocodigo.repository.BookRepository;
import br.com.zup.bookstore.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.MalformedParametersException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(AuthorRepository authorRepository,
                          CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createNewBook(@RequestBody @Valid CreateBookRequest request) {

        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());

        if(optionalAuthor.isEmpty()) {
            throw new MalformedParametersException("Informed author was not found.");
        }

        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());

        if(optionalCategory.isEmpty()) {
            throw new MalformedParametersException("Informed category was not found.");
        }

        Book book = new Book(request, optionalAuthor.get(), optionalCategory.get());
        bookRepository.save(book);

        return ResponseEntity.ok(new BookResponse(book));
    }

}
