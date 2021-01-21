package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CategoryRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.CategoryResponse;
import br.com.zup.bookstore.casadocodigo.model.Category;
import br.com.zup.bookstore.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createNewCategory(@RequestBody CategoryRequest request) {


        Category category = new Category(request);
        repository.save(category);

        return ResponseEntity.ok(new CategoryResponse(request.getName()));
    }

}
