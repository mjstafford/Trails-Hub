package com.launchacademy.reviews.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(InvalidFormDataException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public Map<String, Map<String, String>> InvalidFormDataExceptionHandler(InvalidFormDataException e) {
    Map<String, String> fieldErrors = new HashMap<>();
    for ( FieldError fieldError : e.getFieldErrors()) {
      fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    Map<String, Map<String, String>> errors = new HashMap<>();
    errors.put("errors", fieldErrors);
    return errors;
  }

  @ExceptionHandler(TrailNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public Map<String, String> trailNotFoundExceptionHandler(TrailNotFoundException e) {
    Map<String, String> map = new HashMap<>();
    map.put("error", e.getMessage());
    return map;
  }
}