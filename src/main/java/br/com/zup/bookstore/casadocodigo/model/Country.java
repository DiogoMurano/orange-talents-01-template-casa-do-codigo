package br.com.zup.bookstore.casadocodigo.model;

import br.com.zup.bookstore.casadocodigo.controller.request.CountryRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    public Country(CountryRequest request) {
        this.name = request.getName();
    }

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
