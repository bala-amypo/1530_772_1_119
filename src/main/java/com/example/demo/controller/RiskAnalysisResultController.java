package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisResultController {

    private final RiskAnalysisResultService analysisService;

    public RiskAnalysisResultController(
            RiskAnalysisResultService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public RiskAnalysisResult save(@RequestBody RiskAnalysisResult result) {
        return analysisService.save(result);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getByPortfolio(
            @PathVariable Long portfolioId) {
        return analysisService.getByPortfolio(portfolioId);
    }
}
