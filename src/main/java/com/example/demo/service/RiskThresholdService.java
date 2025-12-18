package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdService {

    RiskThreshold createThreshold(RiskThreshold threshold);

    RiskThreshold getThresholdById(Long id);

    RiskThreshold getActiveThreshold();

    RiskThreshold updateThreshold(Long id, RiskThreshold threshold);

    List<RiskThreshold> getAllThresholds();

}
