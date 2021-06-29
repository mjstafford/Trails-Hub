package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.repositories.TrailRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailService {
  private final TrailRepository trailRepository;
  private final ImageService imageService;

  @Autowired
  public TrailService(TrailRepository trailRepository,
      ImageService imageService) {
    this.trailRepository = trailRepository;
    this.imageService = imageService;
  }

  public Iterable<Trail> findAll() {
    return trailRepository.findAll();
  }

  public Optional<Trail> findById(Integer id) {
    return trailRepository.findById(id);
  }

  public Long count() {
    return trailRepository.count();
  }

  public Trail save(Trail trail) {
    return trailRepository.save(trail);
  }

  public void deleteById(Integer id) {
    trailRepository.deleteById(id);
  }

  public Object create(Trail trail) {
    List<Image> trailImages = new ArrayList<>();
    for (Image image : trail.getImages()) {
      trailImages.add(imageService.findById(image.getId()).get());
    }
    trail.setImages(trailImages);
    return trailRepository.save(trail);
  }
}