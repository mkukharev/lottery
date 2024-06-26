package com.complexica.lottery.user.repository;

import com.complexica.lottery.shared.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByName(String name);
}
