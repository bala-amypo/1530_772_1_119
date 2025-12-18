package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RiskAnalysisResult;

public interface RiskAnalysisResultService {

    RiskAnalysisResult save(RiskAnalysisResult result);

    List<RiskAnalysisResult> getByPortfolio(Long portfolioId);
}
