package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewImage;
import com.launchacademy.reviews.services.ReviewImageService;
import com.launchacademy.reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewImageSeeder {
  private ReviewImageService reviewImageService;
  private ReviewService reviewService;

  @Autowired
  public ReviewImageSeeder(ReviewImageService reviewImageService,
      ReviewService reviewService) {
    this.reviewImageService = reviewImageService;
    this.reviewService = reviewService;
  }

  public void seed() {
    if(reviewImageService.count() == 0) {
      Review review1 = reviewService.findById(1).get();
      Review review2 = reviewService.findById(2).get();

      ReviewImage reviewImage1 = new ReviewImage();
      reviewImage1.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/37326658/extra_large_76a72a82ef41ee95633cf4547f59bd63.jpg");
      reviewImage1.setReview(review1);

      ReviewImage reviewImage2 = new ReviewImage();
      reviewImage1.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/37408533/extra_large_31cbfb3fcf0eafaae4178b718414f75d.jpg");
      reviewImage1.setReview(review1);

      reviewImageService.save(reviewImage1);
      reviewImageService.save(reviewImage2);
    }
  }
}
