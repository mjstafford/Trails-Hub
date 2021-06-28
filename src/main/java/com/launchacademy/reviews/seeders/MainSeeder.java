package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  private TrailSeeder trailSeeder;
  private UserSeeder userSeeder;
  private ReviewSeeder reviewSeeder;
  private ReviewImageSeeder reviewImageSeeder;

  @Autowired
  public MainSeeder(TrailSeeder trailSeeder, UserSeeder userSeeder, ReviewSeeder reviewSeeder,
      ReviewImageSeeder reviewImageSeeder) {
    this.trailSeeder = trailSeeder;
    this.userSeeder = userSeeder;
    this.reviewSeeder = reviewSeeder;
    this.reviewImageSeeder = reviewImageSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    trailSeeder.seed();
    userSeeder.seed();
    reviewSeeder.seed();
    //reviewImageSeeder.seed();
  }
}