package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.isActive());
        return thresholdRepository.save(existing);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return thresholdRepository.findByActiveTrue();
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}
