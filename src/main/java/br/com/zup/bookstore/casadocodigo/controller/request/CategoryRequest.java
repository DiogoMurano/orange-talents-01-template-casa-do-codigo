package br.com.zup.bookstore.casadocodigo.controller.request;

import br.com.zup.bookstore.casadocodigo.model.Category;
import br.com.zup.bookstore.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }
}
