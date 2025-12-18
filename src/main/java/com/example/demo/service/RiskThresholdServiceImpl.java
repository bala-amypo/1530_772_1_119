package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repo;

    public RiskThresholdServiceImpl(RiskThresholdRepository repo) {
        this.repo = repo;
    }

    public RiskThreshold save(RiskThreshold r) {
        return repo.save(r);
    }

    public RiskThreshold getActive() {
        return repo.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
}
