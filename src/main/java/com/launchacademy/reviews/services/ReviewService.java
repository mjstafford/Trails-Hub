package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewImage;
import com.launchacademy.reviews.repositories.ReviewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  private ReviewRepository reviewRepository;
  private ReviewImageService reviewImageService;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository,
      ReviewImageService reviewImageService) {
    this.reviewRepository = reviewRepository;
    this.reviewImageService = reviewImageService;
  }

  public long count() {
    return reviewRepository.count();
  }

  public Optional<Review> findById(int id) {
    return reviewRepository.findById(id);
  }

  public void save(Review review) {
    reviewRepository.save(review);
  }

  public Review updateReview(Review review, Review reviewUpdate) {
    List<ReviewImage> reviewImages = review.getReviewImages();
    review.setRating(reviewUpdate.getRating());
    review.setComment(reviewUpdate.getComment());
    this.save(review);

    ReviewImage imageUpdate = reviewUpdate.getReviewImages().get(0);
    if(reviewImages.size() > 0) {
      if(imageUpdate.getImgUrl().trim().isBlank()) {
        reviewImageService.delete(reviewImages.get(0));
      } else {
        reviewImages.get(0).setImgUrl(imageUpdate.getImgUrl());
        reviewImageService.save(reviewImages.get(0));
      }
    } else {
      if(!imageUpdate.getImgUrl().trim().isBlank()) {
        ReviewImage image = new ReviewImage();
        image.setImgUrl(imageUpdate.getImgUrl());
        image.setReview(review);
        reviewImageService.save(image);
      }
    }
    return review;
  }
}
