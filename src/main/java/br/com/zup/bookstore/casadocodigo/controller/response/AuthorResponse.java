package br.com.zup.bookstore.casadocodigo.controller.response;

import br.com.zup.bookstore.casadocodigo.model.Author;

public class AuthorResponse {

    private String email;
    private String name;
    private String description;

    public AuthorResponse(Author author) {
        this.email = author.getEmail();
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
