package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Image;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {

  Optional<Image> findByImageName(String imageName);
}