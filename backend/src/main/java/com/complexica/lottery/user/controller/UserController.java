package com.complexica.lottery.user.controller;

import com.complexica.lottery.numbers.service.NumberService;
import com.complexica.lottery.shared.entity.LotteryNumber;
import com.complexica.lottery.shared.entity.Requests;
import com.complexica.lottery.shared.entity.User;
import com.complexica.lottery.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;
  private final NumberService numberService;

  public UserController(UserService userService, NumberService numberService) {
    this.userService = userService;
    this.numberService = numberService;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }

  @PostMapping
  public User createUser(@RequestBody Requests.LoginRequest loginRequest) {
    return userService.createUser(loginRequest.getUserName());
  }

  @PostMapping("/{id}/generate-number")
  public LotteryNumber generateRandomNumberForUser(@PathVariable Long id) {
    return numberService.generateRandomNumberForUser(id);
  }
}
