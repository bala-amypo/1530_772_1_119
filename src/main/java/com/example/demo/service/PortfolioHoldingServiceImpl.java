package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    public PortfolioHolding createHolding(PortfolioHolding holding) {

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (holding.getMarketValue().signum() < 0) {
            throw new IllegalArgumentException("Market value cannot be negative");
        }

        return repository.save(holding);
    }

    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);
        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        return repository.save(existing);
    }

    public PortfolioHolding getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }

    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
