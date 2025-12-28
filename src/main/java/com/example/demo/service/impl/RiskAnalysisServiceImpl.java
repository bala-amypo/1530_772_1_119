package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Autowired
    private RiskAnalysisResultRepository analysisRepository;

    @Autowired
    private RiskThresholdRepository thresholdRepository;

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        RiskThreshold threshold = thresholdRepository
                .findFirstByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active risk threshold found"));

        RiskAnalysisResult result = new RiskAnalysisResult();

        result.setPortfolioId(portfolioId);

        result.setAnalysisDate(Timestamp.from(Instant.now()));

        result.setHighestStockPercentage(
                threshold.getMaxSingleStockPercentage()
        );

        result.setHighestSectorPercentage(
                threshold.getMaxSectorPercentage()
        );

        result.setHighRisk(
                threshold.getMaxSingleStockPercentage() > 50 ||
                threshold.getMaxSectorPercentage() > 50
        );

        result.setNotes("Risk analysis completed");

        return analysisRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}
