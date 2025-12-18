package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/api/risk-threshold")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public RiskThreshold add(@RequestBody RiskThreshold r) {
        return service.save(r);
    }

    @GetMapping("/active")
    public RiskThreshold get() {
        return service.getActive();
    }
}
