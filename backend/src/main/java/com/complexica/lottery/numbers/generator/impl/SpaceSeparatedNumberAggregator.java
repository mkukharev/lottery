package com.complexica.lottery.numbers.generator.impl;
import com.complexica.lottery.numbers.generator.NumberAggregator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceSeparatedNumberAggregator implements NumberAggregator {

  @Override
  public String aggregate(List<Integer> numbers) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numbers.size(); i++) {
      result.append(numbers.get(i));
      if (i < numbers.size() - 1) {
        result.append(" ");
      }
    }
    return result.toString();
  }
}
