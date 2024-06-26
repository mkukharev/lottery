package com.complexica.lottery.numbers.generator;

import java.util.List;

/**
 * Generates the String
 * by aggregating the given numbers into a resulting String based on the rules provided in the implementation
 */
public interface NumberAggregator {
  String aggregate(List<Integer> numbers);
}
