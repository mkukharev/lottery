package com.complexica.lottery;

import com.complexica.lottery.numbers.repository.NumberRepository;
import com.complexica.lottery.numbers.service.NumberService;
import com.complexica.lottery.shared.entity.LotteryNumber;
import com.complexica.lottery.shared.entity.User;
import com.complexica.lottery.user.repository.UserRepository;
import com.complexica.lottery.user.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class LotteryApplicationTests {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private NumberRepository numberRepository;

  @Autowired
  private NumberService numberService;

  @BeforeEach
  public void setup() {
    userRepository.deleteAll();
    numberRepository.deleteAll();
  }

  @Test
  public void testCreateUser() {
    User user = userService.createUser("John");
    assertThat(user.getId()).isNotNull();
    assertThat(user.getNumbers()).isNotNull();
    assertThat(user.getName()).isEqualTo("john");
  }

  @Test
  public void testGetAllUsers() {
    userService.createUser("John");
    userService.createUser("Jane");
    List<User> users = userService.getAllUsers();
    assertThat(users).hasSize(2);
  }

  @Test
  public void testGetSimilarNames() {
    userService.createUser("John");
    userService.createUser("john");
    userService.createUser(" john ");
    userService.createUser("JOHN");
    userService.createUser("JOHN ");
    List<User> users = userService.getAllUsers();
    assertThat(users).hasSize(1);
  }

  @Test
  public void testGenerateRandomNumberForUser() {
    User user = userService.createUser("John");
    LotteryNumber lotteryNumber = numberService.generateRandomNumberForUser(user.getId());
    assertThat(lotteryNumber.getId()).isNotNull();
    assertThat(lotteryNumber.getNumber()).isNotNull();
    assertThat(lotteryNumber.getGeneratedAt()).isNotNull();
    assertThat(lotteryNumber.getUser().getId()).isEqualTo(user.getId());
  }

}
