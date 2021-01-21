package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CategoryRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.CategoryResponse;
import br.com.zup.bookstore.casadocodigo.model.Category;
import br.com.zup.bookstore.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<CategoryResponse> createNewCategory(@RequestBody CategoryRequest request) {
        String name = request.getName();

        Optional<Category> optional = repository.findByName(name);

        if (optional.isPresent()) {
            throw new ValidationException(String.format("%s category already exists", name));
        }

        Category category = new Category(request);
        repository.save(category);

        return ResponseEntity.ok(new CategoryResponse(name));
    }

}
