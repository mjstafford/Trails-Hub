package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.ReviewImage;
import com.launchacademy.reviews.repositories.ReviewImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewImageService {

  private ReviewImageRepository reviewImageRepository;

  @Autowired
  public ReviewImageService(ReviewImageRepository reviewImageRepository) {
    this.reviewImageRepository = reviewImageRepository;
  }

  public long count() {
    return reviewImageRepository.count();
  }

  public void save(ReviewImage reviewImage) {
    reviewImageRepository.save(reviewImage);
  }
}
