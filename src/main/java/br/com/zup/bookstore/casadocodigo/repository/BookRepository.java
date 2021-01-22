package br.com.zup.bookstore.casadocodigo.repository;

import br.com.zup.bookstore.casadocodigo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
