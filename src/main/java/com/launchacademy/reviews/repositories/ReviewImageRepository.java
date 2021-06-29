package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewImage;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewImageRepository extends CrudRepository<ReviewImage, Integer> {

  List<ReviewImage> findByReview(Review review);
}
