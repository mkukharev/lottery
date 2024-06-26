package com.complexica.lottery.user.service;

import com.complexica.lottery.shared.entity.User;
import com.complexica.lottery.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(String name) {
    String trimmedName = name.trim().toLowerCase();
    Optional<User> maybeUser = userRepository.findByName(trimmedName);
    return maybeUser.orElseGet(() -> userRepository.save(new User(trimmedName)));
  }
}
