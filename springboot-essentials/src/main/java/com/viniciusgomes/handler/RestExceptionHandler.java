package com.viniciusgomes.handler;

import com.viniciusgomes.error.ErrorDetails;
import com.viniciusgomes.error.ResourceNotFoundDetails;
import com.viniciusgomes.error.ResourceNotFoundException;
import com.viniciusgomes.error.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {

        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder.newBuilder()
                .timestamp(ZonedDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
                                                          HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {

        List<FieldError> fieldError = manvException.getBindingResult().getFieldErrors();
        String fields = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationErrorDetails vldDetaiils = ValidationErrorDetails.Builder.newBuilder()
                .timestamp(ZonedDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validation Error")
                .detail("Field Validation Error")
                .developerMessage(manvException.getClass().getName())
                .field(fields)
                .fieldMessage(fieldMessages)
                .build();

        return new ResponseEntity<>(vldDetaiils, HttpStatus.BAD_REQUEST);
    }



    // Método Genérico de tratamento de erro para todas as mensagens de erro que
    // ainda não foram tratados
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             @Nullable Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.Builder.newBuilder()
                .timestamp(ZonedDateTime.now())
                .status(status.value())
                .title("Internal Exception")
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(errorDetails, headers, status);
    }



}
