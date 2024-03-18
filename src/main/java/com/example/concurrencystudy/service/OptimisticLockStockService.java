package com.example.concurrencystudy.service;

import com.example.concurrencystudy.domain.Stock;
import com.example.concurrencystudy.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptimisticLockStockService {
    private final StockRepository stockRepository;

    public OptimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrese(Long id, Long quantity) {
        Stock stock = stockRepository.findByWithOptimisticLock(id);

        stock.decrese(quantity);
        stockRepository.save(stock);
    }
}
