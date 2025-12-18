package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;

@Service
public class RiskAnalysisResultServiceImpl
        implements RiskAnalysisResultService {

    private final RiskAnalysisResultRepository repo;

    public RiskAnalysisResultServiceImpl(RiskAnalysisResultRepository repo) {
        this.repo = repo;
    }

    public RiskAnalysisResult save(RiskAnalysisResult r) {
        return repo.save(r);
    }

    public List<RiskAnalysisResult> getByPortfolio(Long id) {
        return repo.findByPortfolioId(id);
    }
}
