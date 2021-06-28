package com.launchacademy.reviews.services;

import com.launchacademy.reviews.exceptions.TrailNotFoundException;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.models.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewFormService {
  private final TrailService trailService;
  private final UserService userService;
  private final ReviewService reviewService;

  @Autowired
  public ReviewFormService(TrailService trailService,
      UserService userService, ReviewService reviewService
      ) {
    this.trailService = trailService;
    this.userService = userService;
    this.reviewService = reviewService;
  }

  public Review processForm(ReviewForm reviewForm) {
    Integer trailId = reviewForm.getTrailId();
    Trail trail = trailService.findById(trailId)
        .orElseThrow(() -> new TrailNotFoundException(trailId));

    String userName = reviewForm.getName();
    Optional<User> userResult = userService.findByName(userName);
    User user;
    if (userResult.isEmpty()) {
      user = new User();
      user.setName(userName);
      userService.save(user);
    }
    else {
      user = userResult.get();
    }

    Review review = new Review();
    review.setRating(reviewForm.getRating());
    review.setComment(reviewForm.getComment());
    review.setTrail(trail);
    review.setUser(user);
    reviewService.save(review);

    if (!reviewForm.getImgUrl().isBlank()) {
      Image image = new Image();
//      image.setReview(review);
//      image.setImgUrl(reviewForm.getImgUrl());
    //  reviewImageService.save(image);
    }
    return review;
  }
}