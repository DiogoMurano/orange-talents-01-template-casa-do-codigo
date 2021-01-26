package br.com.zup.bookstore.casadocodigo.controller;

import br.com.zup.bookstore.casadocodigo.controller.request.NewBuyRequest;
import br.com.zup.bookstore.casadocodigo.validator.ValidCountryAndStateValidator;
import br.com.zup.bookstore.casadocodigo.validator.ValidDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/buy")
public class BuyController {

    @Autowired
    private ValidCountryAndStateValidator countryAndStateValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new ValidDocumentValidator());
        binder.addValidators(countryAndStateValidator);
    }

    @PostMapping
    public String createNewBuy(@RequestBody @Valid NewBuyRequest request) {
        return request.toString();
    }

}
