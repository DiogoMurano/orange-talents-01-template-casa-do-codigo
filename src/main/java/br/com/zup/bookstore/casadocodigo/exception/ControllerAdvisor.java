package br.com.zup.bookstore.casadocodigo.exception;

import br.com.zup.bookstore.casadocodigo.controller.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setDateTime(LocalDateTime.now());

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        ObjectError objectError = errors.stream().findFirst().orElse(null);

        response.setMessage(objectError != null ? objectError.getDefaultMessage() : "Some of the parameters sent were rejected.");

        return ResponseEntity.badRequest().body(response);
    }
}
