package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.CountryRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.CountryResponse;
import br.com.zup.bookstore.casadocodigo.model.Country;
import br.com.zup.bookstore.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> createNewCountry(@RequestBody @Valid CountryRequest request) {
        Country country = new Country(request);
        repository.save(country);

        return ResponseEntity.ok(new CountryResponse(country));
    }

}
