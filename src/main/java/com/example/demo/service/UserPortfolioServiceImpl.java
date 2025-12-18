package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = getPortfolioById(id);
        existing.setPortfolioName(portfolio.getPortfolioName());
        return repository.save(existing);
    }

    public UserPortfolio getPortfolioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }

    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
