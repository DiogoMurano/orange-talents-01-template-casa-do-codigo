package br.com.zup.bookstore.casadocodigo.controller.response;

public class CategoryResponse {

    private final String name;

    public CategoryResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
