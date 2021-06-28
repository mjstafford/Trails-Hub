package com.launchacademy.reviews.exceptions;

public class ReviewNotFoundException extends RuntimeException {

  public ReviewNotFoundException(Integer id) {
    super("Review not found with id " + id);
  }
}