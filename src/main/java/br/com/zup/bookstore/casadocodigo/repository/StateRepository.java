package br.com.zup.bookstore.casadocodigo.repository;

import br.com.zup.bookstore.casadocodigo.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
}
