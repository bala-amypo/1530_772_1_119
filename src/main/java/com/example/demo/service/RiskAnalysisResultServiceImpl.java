package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;

@Service
public class RiskAnalysisResultServiceImpl
        implements RiskAnalysisResultService {

    private final RiskAnalysisResultRepository repository;

    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    public RiskAnalysisResult save(RiskAnalysisResult result) {
        return repository.save(result);
    }

    public List<RiskAnalysisResult> getByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
