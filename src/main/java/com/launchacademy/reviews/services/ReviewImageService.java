package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewImage;
import com.launchacademy.reviews.repositories.ReviewImageRepository;
import java.util.List;
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

  public List<ReviewImage> findByReview(Review review) {
    return reviewImageRepository.findByReview(review);
  }

  public void deleteById(Integer id) {
    reviewImageRepository.deleteById(id);
  }

  public void delete(ReviewImage reviewImage) {
    reviewImageRepository.delete(reviewImage);
  }
}
