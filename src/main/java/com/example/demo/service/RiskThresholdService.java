package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RiskThreshold;

public interface RiskThresholdService {

    RiskThreshold createThreshold(RiskThreshold threshold);

    RiskThreshold updateThreshold(Long id, RiskThreshold threshold);

    RiskThreshold getThresholdById(Long id);

    RiskThreshold getActiveThreshold();

    List<RiskThreshold> getAllThresholds();
}
