package br.com.zup.bookstore.casadocodigo.controller.request;

import br.com.zup.bookstore.casadocodigo.model.State;
import br.com.zup.bookstore.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateRequest {

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name")
    private String name;

    @NotNull
    private Long countryId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}
