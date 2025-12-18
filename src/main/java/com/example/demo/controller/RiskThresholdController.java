package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold threshold) {
        return thresholdService.createThreshold(threshold);
    }

    @GetMapping("/{id}")
    public RiskThreshold getById(@PathVariable Long id) {
        return thresholdService.getThresholdById(id);
    }
}
