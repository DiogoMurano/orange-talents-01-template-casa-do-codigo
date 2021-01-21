package br.com.zup.bookstore.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }
}
