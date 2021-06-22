package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.repositories.TrailRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailService {
  private TrailRepository trailRepository;

  @Autowired
  public TrailService(TrailRepository trailRepository) {
    this.trailRepository = trailRepository;
  }

  public Iterable<Trail> findAll() {
    return trailRepository.findAll();
  }

  public Long count() {
    return trailRepository.count();
  }

  public void save(Trail trail) {
    trailRepository.save(trail);
  }

  public Optional<Trail> findById(int id) {
    return trailRepository.findById(id);
  }
}
