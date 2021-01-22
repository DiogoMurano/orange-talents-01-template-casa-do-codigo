package br.com.zup.bookstore.casadocodigo.exception;

import br.com.zup.bookstore.casadocodigo.controller.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.MalformedParametersException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MalformedParametersException.class)
    public ResponseEntity<ErrorResponse> handleMalformedParametersException(MalformedParametersException e) {
        return ResponseEntity.badRequest().body(create(e.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        ObjectError objectError = errors.stream().findFirst().orElse(null);

        ErrorResponse response = create(objectError != null ? objectError
                .getDefaultMessage() : "Some of the parameters sent were rejected.");

        return ResponseEntity.badRequest().body(response);
    }

    private ErrorResponse create(String message) {
        ErrorResponse response = new ErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setDateTime(LocalDateTime.now());
        response.setMessage(message);

        return response;
    }

}