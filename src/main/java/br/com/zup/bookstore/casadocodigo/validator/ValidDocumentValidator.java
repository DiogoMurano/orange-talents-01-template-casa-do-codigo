package br.com.zup.bookstore.casadocodigo.validator;

import br.com.zup.bookstore.casadocodigo.controller.request.NewBuyRequest;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidDocumentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewBuyRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NewBuyRequest request = (NewBuyRequest) target;

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        String document = request.getDocument();

        if(cnpjValidator.isValid(document, null) || cpfValidator.isValid(document, null)) {
            return;
        }

        errors.rejectValue("document", "The document entered isn't valid.");

    }
}
