package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;
    private final RiskAnalysisResultRepository resultRepository;

    public RiskAnalysisServiceImpl(UserPortfolioRepository portfolioRepository,
                                   PortfolioHoldingRepository holdingRepository,
                                   RiskThresholdRepository thresholdRepository,
                                   RiskAnalysisResultRepository resultRepository) {
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        List<PortfolioHolding> holdings =
                holdingRepository.findByPortfolioId(portfolioId);

        BigDecimal totalMarketValue = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highestPercentage = holdings.stream()
                .mapToDouble(h ->
                        h.getMarketValue()
                         .divide(totalMarketValue, 6, RoundingMode.HALF_UP)
                         .doubleValue() * 100
                )
                .max()
                .orElse(0);

        RiskThreshold threshold =
                thresholdRepository.findByPortfolioId(portfolioId).orElse(null);

        boolean isHighRisk = threshold != null &&
                highestPercentage > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(highestPercentage);
        result.setIsHighRisk(isHighRisk);

        return resultRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {

        portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        return resultRepository.findByPortfolioId(portfolioId);
    }
}
