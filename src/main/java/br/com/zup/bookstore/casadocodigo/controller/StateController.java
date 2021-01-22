package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.StateRequest;
import br.com.zup.bookstore.casadocodigo.controller.response.StateResponse;
import br.com.zup.bookstore.casadocodigo.model.Country;
import br.com.zup.bookstore.casadocodigo.model.State;
import br.com.zup.bookstore.casadocodigo.repository.CountryRepository;
import br.com.zup.bookstore.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/state")
public class StateController {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    @Autowired
    public StateController(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    @PostMapping
    public ResponseEntity<StateResponse> createNewState(@RequestBody @Valid StateRequest request) {
        Long countryId = request.getCountryId();

        Optional<Country> optional = countryRepository.findById(countryId);

        if(optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found.");
        }

        State state = new State(request, optional.get());
        stateRepository.save(state);

        return ResponseEntity.ok(new StateResponse(state));
    }

}
