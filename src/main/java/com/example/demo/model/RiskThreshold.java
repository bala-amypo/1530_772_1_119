package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thresholdName;

    private Double maxSingleStockPercentage;

    private Double maxSectorPercentage;

    private boolean active;

    public RiskThreshold() {}

    public Long getId() {
        return id;
    }

    public String getThresholdName() {
        return thresholdName;
    }

    public void setThresholdName(String thresholdName) {
        this.thresholdName = thresholdName;
    }

    public Double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }

    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }

    public Double getMaxSectorPercentage() {
        return maxSectorPercentage;
    }

    public void setMaxSectorPercentage(Double maxSectorPercentage) {
        this.maxSectorPercentage = maxSectorPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
