package com.launchacademy.reviews.exceptions;

public class TrailNotFoundException extends RuntimeException {

  public TrailNotFoundException(Integer id) {
    super("Trail not found with id " + id);
  }
}