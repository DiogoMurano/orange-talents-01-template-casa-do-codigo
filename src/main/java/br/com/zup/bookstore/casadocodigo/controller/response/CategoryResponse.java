package br.com.zup.bookstore.casadocodigo.controller.response;

import br.com.zup.bookstore.casadocodigo.model.Category;

public class CategoryResponse {

    private final String name;

    public CategoryResponse(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }
}
