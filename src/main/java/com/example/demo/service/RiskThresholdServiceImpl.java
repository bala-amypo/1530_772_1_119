package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository,
                                    UserPortfolioRepository portfolioRepository) {
        this.thresholdRepository = thresholdRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Invalid max single stock percentage");
        }

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        RiskThreshold existing =
                thresholdRepository.findByPortfolioId(portfolioId).orElse(null);

        if (existing != null) {
            existing.setMaxSingleStockPercentage(
                    threshold.getMaxSingleStockPercentage());
            existing.setMaxOverallVolatility(
                    threshold.getMaxOverallVolatility());
            return thresholdRepository.save(existing);
        }

        threshold.setPortfolio(portfolio);
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {

        portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        return thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Risk threshold not found"));
    }
}
