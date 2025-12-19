package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;

@Service
public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService {

    private final RiskAnalysisResultRepository analysisRepository;

    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighRisk(false);
        return analysisRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}
