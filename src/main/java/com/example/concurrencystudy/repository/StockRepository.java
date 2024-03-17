package com.example.concurrencystudy.repository;

import com.example.concurrencystudy.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
