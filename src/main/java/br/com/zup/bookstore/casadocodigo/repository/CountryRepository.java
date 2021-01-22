package br.com.zup.bookstore.casadocodigo.repository;

import br.com.zup.bookstore.casadocodigo.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
