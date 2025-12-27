package com.example.demo.model;

import java.sql.Timestamp;

public class RiskAnalysisResult {

    private Long id;
    private UserPortfolio portfolio;
    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Boolean highRisk;

    public RiskAnalysisResult() {}

    public RiskAnalysisResult(UserPortfolio portfolio, Timestamp analysisDate,
                              Double highestStockPercentage, Boolean highRisk) {
        this.portfolio = portfolio;
        this.analysisDate = analysisDate;
        this.highestStockPercentage = highestStockPercentage;
        this.highRisk = highRisk;
    }

    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }

    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Boolean isHighRisk() { return highRisk; }
    public void setHighRisk(Boolean highRisk) { this.highRisk = highRisk; }
}
