package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  private TrailSeeder trailSeeder;

  @Autowired
  public MainSeeder(TrailSeeder trailSeeder) {
    this.trailSeeder = trailSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    trailSeeder.seed();
  }
}
