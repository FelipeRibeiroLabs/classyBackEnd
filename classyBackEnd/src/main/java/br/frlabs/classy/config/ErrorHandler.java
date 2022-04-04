package br.frlabs.classy.config;

import br.frlabs.classy.exception.ApiException;
import br.frlabs.classy.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @Autowired
    public MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ApiException> handler (MethodArgumentNotValidException exception){

        List<ApiException> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ApiException error = new ApiException(message, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
            errors.add(error);
        });

        return errors;
    }

        @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(
                e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))
        );

        return ResponseEntity.badRequest().body(apiException);
    }

}
