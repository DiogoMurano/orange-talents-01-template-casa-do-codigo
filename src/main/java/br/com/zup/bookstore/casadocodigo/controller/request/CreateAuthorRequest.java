package br.com.zup.bookstore.casadocodigo.controller.request;

import br.com.zup.bookstore.casadocodigo.model.Author;
import br.com.zup.bookstore.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateAuthorRequest {

    @NotEmpty
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 400)
    private String description;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
