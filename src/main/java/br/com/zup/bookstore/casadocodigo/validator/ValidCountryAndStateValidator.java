package br.com.zup.bookstore.casadocodigo.validator;

import br.com.zup.bookstore.casadocodigo.controller.request.NewBuyRequest;
import br.com.zup.bookstore.casadocodigo.model.Country;
import br.com.zup.bookstore.casadocodigo.model.State;
import br.com.zup.bookstore.casadocodigo.repository.CountryRepository;
import br.com.zup.bookstore.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidCountryAndStateValidator implements Validator {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewBuyRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewBuyRequest request = (NewBuyRequest) target;

        Optional<Country> optionalCountry = countryRepository.findById(request.getCountryId());
        Optional<State> optionalState = stateRepository.findById(request.getStateId());

        if(optionalCountry.isEmpty()) {
            errors.rejectValue("countryId", "Country not found.");
            return;
        }

        Country country = optionalCountry.get();

        if(optionalState.isEmpty() || !optionalState.get().sameCountry(country)) {
            errors.rejectValue("stateId", "State not found.");
        }
    }
}
