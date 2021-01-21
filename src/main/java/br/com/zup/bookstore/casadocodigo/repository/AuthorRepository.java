package br.com.zup.bookstore.casadocodigo.repository;

import br.com.zup.bookstore.casadocodigo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
