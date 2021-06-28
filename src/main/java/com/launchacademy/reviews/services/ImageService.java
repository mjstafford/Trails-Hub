package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
  private final ImageRepository repository;

  @Autowired
  public ImageService(ImageRepository repository) {
    this.repository = repository;
  }

  public Image save(Image image) {
    return repository.save(image);
  }


}
