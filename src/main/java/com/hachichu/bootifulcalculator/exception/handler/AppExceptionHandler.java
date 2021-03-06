package com.hachichu.bootifulcalculator.exception.handler;

import com.hachichu.bootifulcalculator.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by djames
 * 06/03/2021  11:13 PM
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.debug("MethodArgumentNotValidException encountered: ", ex);
        FieldError error = ex.getBindingResult().getFieldErrors().get(0);
        String errorMessage = String.format("%s %s", error.getField(), error.getDefaultMessage());
        ErrorResponse response = ErrorResponse.builder()
                .error(errorMessage)
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.debug("HttpMessageNotReadableException encountered: ", ex);
        ErrorResponse response = ErrorResponse.builder()
                .error(ex.getCause().getCause().getMessage())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        log.error("Unknown Exception encountered. ", e);
        ErrorResponse response = ErrorResponse.builder()
                .error("The service is currently not available. Please Try again later.")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}

