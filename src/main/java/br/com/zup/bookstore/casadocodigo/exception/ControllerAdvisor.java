package br.com.zup.bookstore.casadocodigo.exception;

import br.com.zup.bookstore.casadocodigo.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception) {
        ErrorResponse response = new ErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

}
