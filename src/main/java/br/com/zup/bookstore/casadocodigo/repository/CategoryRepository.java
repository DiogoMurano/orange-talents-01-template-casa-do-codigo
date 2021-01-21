package br.com.zup.bookstore.casadocodigo.repository;

import br.com.zup.bookstore.casadocodigo.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
