package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findByName(String name);
}
