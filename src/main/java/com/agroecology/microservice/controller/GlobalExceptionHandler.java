package com.agroecology.microservice.controller;

import com.agroecology.microservice.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected @ResponseBody ErrorResponse handleNotFound(NotFoundException ex) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            ex.getMessage());
  }

  @Data
  @AllArgsConstructor
  static class ErrorResponse {
    private int status;
    private String error;
    private String message;
  }
}
