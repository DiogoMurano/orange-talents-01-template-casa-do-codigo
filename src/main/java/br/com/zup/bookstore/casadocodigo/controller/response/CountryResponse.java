package br.com.zup.bookstore.casadocodigo.controller.response;

import br.com.zup.bookstore.casadocodigo.model.Country;

public class CountryResponse {

    private String name;

    public CountryResponse(Country country) {
        this.name = country.getName();
    }

    public String getName() {
        return name;
    }
}
