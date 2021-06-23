package com.launchacademy.reviews.exceptions;

import java.util.List;
import org.springframework.validation.FieldError;

public class InvalidFormDataException extends RuntimeException {
  private List<FieldError> fieldErrors;

  public InvalidFormDataException(List<FieldError> fieldErrors) {
    this.fieldErrors = fieldErrors;
  }

  public List<FieldError> getFieldErrors() {
    return fieldErrors;
  }
}