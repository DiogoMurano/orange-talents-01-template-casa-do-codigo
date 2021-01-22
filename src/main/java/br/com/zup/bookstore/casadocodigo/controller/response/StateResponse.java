package br.com.zup.bookstore.casadocodigo.controller.response;

import br.com.zup.bookstore.casadocodigo.model.State;

public class StateResponse {

    private String name;

    private CountryResponse country;

    public StateResponse(State state) {
        this.name = state.getName();
        this.country = new CountryResponse(state.getCountry());
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountry() {
        return country;
    }
}
