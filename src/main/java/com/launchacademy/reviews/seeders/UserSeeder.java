package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.User;
import com.launchacademy.reviews.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {
  private UserService userService;

  @Autowired
  public UserSeeder(UserService userService) {
    this.userService = userService;
  }

  public void seed() {
    if(userService.count() == 0) {
      User user1 = new User();
      user1.setName("Willy Wonka");


      User user2 = new User();
      user2.setName("Charlie Carpenter");

      userService.save(user1);
      userService.save(user2);
    }
  }
}
