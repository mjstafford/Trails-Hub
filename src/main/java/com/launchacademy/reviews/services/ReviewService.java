package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.repositories.ReviewRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public long count() {
    return reviewRepository.count();
  }

  public Optional<Review> findById(int id) {
    return reviewRepository.findById(id);
  }

  public Review save(Review review) {
    return reviewRepository.save(review);
  }

  public void deleteById(Integer id) {
    reviewRepository.deleteById(id);
  }
}
