package com.complexica.lottery.numbers.generator.impl;

import com.complexica.lottery.numbers.generator.LotteryNumberGenerator;
import com.complexica.lottery.numbers.generator.NumberAggregator;
import com.complexica.lottery.numbers.generator.NumberBlockGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotteryNumberGeneratorImpl implements LotteryNumberGenerator {

  private final NumberBlockGenerator numberBlockGenerator;
  private final NumberAggregator numberAggregator;

  private static final int SEQUENCE_LENGTH = 6;

  @Autowired
  public LotteryNumberGeneratorImpl(NumberBlockGenerator numberBlockGenerator, NumberAggregator numberAggregator) {
    this.numberBlockGenerator = numberBlockGenerator;
    this.numberAggregator = numberAggregator;
  }

  @Override
  public String generate() {
    Set<Integer> numbersSet = new HashSet<>();

    while (numbersSet.size() < SEQUENCE_LENGTH) {
      int number = numberBlockGenerator.generate();
      numbersSet.add(number);
    }

    List<Integer> numbersList = new ArrayList<>(numbersSet);
    numbersList.sort(Integer::compareTo);

    return numberAggregator.aggregate(numbersList);
  }
}
