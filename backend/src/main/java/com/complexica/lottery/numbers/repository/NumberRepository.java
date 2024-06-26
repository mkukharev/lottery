package com.complexica.lottery.numbers.repository;

import com.complexica.lottery.shared.entity.LotteryNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<LotteryNumber, Long> {
}
