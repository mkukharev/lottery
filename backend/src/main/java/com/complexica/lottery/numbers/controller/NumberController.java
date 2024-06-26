package com.complexica.lottery.numbers.controller;

import com.complexica.lottery.numbers.service.NumberService;
import com.complexica.lottery.shared.entity.LotteryNumber;
import com.complexica.lottery.shared.entity.Requests;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

  private final NumberService numberService;

  public NumberController(NumberService numberService) {
    this.numberService = numberService;
  }

  @PostMapping("/generate")
  public LotteryNumber generateRandomNumberForUser(@RequestBody Requests.NewNumberRequest newNumberRequest) {
    return numberService.generateRandomNumberForUser(newNumberRequest.getUserId());
  }
}
