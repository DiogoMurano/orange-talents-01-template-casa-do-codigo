package br.com.zup.bookstore.casadocodigo.model;

import br.com.zup.bookstore.casadocodigo.controller.request.CategoryRequest;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    public Category() {
    }

    public Category(CategoryRequest request) {
        this.name = request.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
