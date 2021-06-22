package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.User;
import com.launchacademy.reviews.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;
  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public long count() {
    return userRepository.count();
  }

  public void save(User user) {
    userRepository.save(user);
  }

  public Optional<User> findById(int id) {
    return userRepository.findById(id);
  }
}
