package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        return threshold;
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
        return null;
    }
}
