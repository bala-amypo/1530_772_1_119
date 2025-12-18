package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisResultController {

    private final RiskAnalysisResultService service;

    public RiskAnalysisResultController(RiskAnalysisResultService service) {
        this.service = service;
    }

    @PostMapping
    public RiskAnalysisResult add(@RequestBody RiskAnalysisResult r) {
        return service.save(r);
    }

    @GetMapping("/portfolio/{id}")
    public List<RiskAnalysisResult> get(@PathVariable Long id) {
        return service.getByPortfolio(id);
    }
}
