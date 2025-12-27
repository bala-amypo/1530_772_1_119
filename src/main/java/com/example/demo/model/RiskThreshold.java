package com.example.demo.model;

public class RiskThreshold {

    private Long id;
    private UserPortfolio portfolio;
    private Double maxSingleStockPercentage;
    private Double maxOverallVolatility;

    public RiskThreshold() {}

    public RiskThreshold(UserPortfolio portfolio, Double maxSingleStockPercentage, Double maxOverallVolatility) {
        this.portfolio = portfolio;
        this.maxSingleStockPercentage = maxSingleStockPercentage;
        this.maxOverallVolatility = maxOverallVolatility;
    }

    public Double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }
}
