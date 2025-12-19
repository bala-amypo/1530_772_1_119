package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    public RiskThreshold createThreshold(RiskThreshold threshold) {

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }

        return repository.save(threshold);
    }

    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }
    @Override
public List<RiskThreshold> getAllThresholds() {
    return thresholdRepository.findAll();
}

}
