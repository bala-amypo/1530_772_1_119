package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repo;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repo) {
        this.repo = repo;
    }

    public PortfolioHolding createHolding(PortfolioHolding h) {
        return repo.save(h);
    }

    public List<PortfolioHolding> getByPortfolio(Long id) {
        return repo.findByPortfolioId(id);
    }
}
