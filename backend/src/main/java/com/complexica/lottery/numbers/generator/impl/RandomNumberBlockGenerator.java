package com.complexica.lottery.numbers.generator.impl;

import com.complexica.lottery.numbers.generator.NumberBlockGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberBlockGenerator implements NumberBlockGenerator {

  private static final int RANGE_START = 1;
  private static final int RANGE_END = 45;

  @Override
  public Integer generate() {
    Random random = new Random();

    return random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
  }
}
