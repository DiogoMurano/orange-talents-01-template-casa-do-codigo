package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateAuthorRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.AuthorResponse;
import br.com.zup.bookstore.casadocodigo.model.Author;
import br.com.zup.bookstore.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createNewAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        String email = request.getEmail();

        Optional<Author> optional = authorRepository.findByEmail(email);

        if(optional.isPresent()) {
            throw new ValidationException(email + " already belongs to a registered author.");
        }

        Author author = new Author(email, request.getName(), request.getDescription());
        authorRepository.save(author);

        AuthorResponse response = new AuthorResponse(author);
        return ResponseEntity.ok(response);
    }

}
