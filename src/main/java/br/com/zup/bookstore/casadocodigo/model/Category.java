package br.com.zup.bookstore.casadocodigo.model;

import br.com.zup.bookstore.casadocodigo.controller.request.CreateCategoryRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
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

    public Category(CreateCategoryRequest request) {
        this.name = request.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
