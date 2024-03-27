package com.example.concurrencystudy.facade;

import com.example.concurrencystudy.repository.LockRepository;
import com.example.concurrencystudy.service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NamedLockStockFacde {
    private final LockRepository lockRepository;

    private final StockService stockSerive;

    public NamedLockStockFacde(LockRepository lockRepository, StockService stockSerive) {
        this.lockRepository = lockRepository;
        this.stockSerive = stockSerive;
    }

    @Transactional
    public void decrese(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockSerive.decrese(id, quantity);
        } finally {
            lockRepository.releaseLock(id.toString());
        }
    }

}
