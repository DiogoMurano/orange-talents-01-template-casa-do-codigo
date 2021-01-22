package br.com.zup.bookstore.casadocodigo.service;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateBookRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.BookResponse;
import br.com.zup.bookstore.casadocodigo.controller.response.DetailedBookResponse;
import br.com.zup.bookstore.casadocodigo.model.Author;
import br.com.zup.bookstore.casadocodigo.model.Book;
import br.com.zup.bookstore.casadocodigo.model.Category;
import br.com.zup.bookstore.casadocodigo.repository.AuthorRepository;
import br.com.zup.bookstore.casadocodigo.repository.BookRepository;
import br.com.zup.bookstore.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(AuthorRepository authorRepository,
                       CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    public DetailedBookResponse createNewBook(CreateBookRequest request) {
        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());

        if (optionalAuthor.isEmpty()) {
            throw new MalformedParametersException("Informed author was not found.");
        }

        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());

        if (optionalCategory.isEmpty()) {
            throw new MalformedParametersException("Informed category was not found.");
        }

        Book book = new Book(request, optionalAuthor.get(), optionalCategory.get());
        bookRepository.save(book);

        return new DetailedBookResponse(book);
    }

    public List<BookResponse> listAllBooks() {
        Iterable<Book> iterator = bookRepository.findAll();

        List<Book> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().map(BookResponse::new).collect(Collectors.toList());
    }

    public DetailedBookResponse findById(Long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found.");
        }

        Book book = optional.get();
        return new DetailedBookResponse(book);
    }

}
