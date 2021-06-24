package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.repositories.TrailRepository;
import java.util.List;
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
}