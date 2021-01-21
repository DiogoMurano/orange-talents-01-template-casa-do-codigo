package br.com.zup.bookstore.casadocodigo.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateAuthorRequest {

    @NotEmpty
    @Email
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
