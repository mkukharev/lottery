package com.complexica.lottery.numbers.service;

import com.complexica.lottery.numbers.generator.LotteryNumberGenerator;
import com.complexica.lottery.numbers.repository.NumberRepository;
import com.complexica.lottery.shared.entity.LotteryNumber;
import com.complexica.lottery.shared.entity.User;
import com.complexica.lottery.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NumberService {

  private final NumberRepository numberRepository;
  private final UserRepository userRepository;
  private final LotteryNumberGenerator lotteryNumberGenerator;

  @Autowired
  public NumberService(NumberRepository numberRepository, UserRepository userRepository, LotteryNumberGenerator lotteryNumberGenerator) {
    this.numberRepository = numberRepository;
    this.userRepository = userRepository;
    this.lotteryNumberGenerator = lotteryNumberGenerator;
  }

  public LotteryNumber generateRandomNumberForUser(Long userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    String generatedNumbersString = lotteryNumberGenerator.generate();

    LotteryNumber lotteryNumber = new LotteryNumber();
    lotteryNumber.setUser(user);
    lotteryNumber.setNumber(generatedNumbersString);
    lotteryNumber.setGeneratedAt(LocalDateTime.now());

    numberRepository.save(lotteryNumber);

    return lotteryNumber;
  }
}
