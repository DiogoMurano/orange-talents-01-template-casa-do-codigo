package br.com.zup.bookstore.casadocodigo.controller.request;

import br.com.zup.bookstore.casadocodigo.model.Country;
import br.com.zup.bookstore.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }
}
