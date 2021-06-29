package com.launchacademy.reviews.services;

import com.launchacademy.reviews.exceptions.TrailNotFoundException;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewFormService {
  private final TrailService trailService;
  private final UserService userService;
  private final ReviewService reviewService;
  private final ImageService imageService;

  @Autowired
  public ReviewFormService(TrailService trailService,
      UserService userService, ReviewService reviewService,
      ImageService imageService) {
    this.trailService = trailService;
    this.userService = userService;
    this.reviewService = reviewService;
    this.imageService = imageService;
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

    System.out.println(reviewForm.getImages());
    List<Image> reviewImages = new ArrayList<>();
    for (Image image : reviewForm.getImages()) {
      reviewImages.add(imageService.findById(image.getId()).get());
    }
    review.setImages(reviewImages);

    return reviewService.save(review);
  }
}