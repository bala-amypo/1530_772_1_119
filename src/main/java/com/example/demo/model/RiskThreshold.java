package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double maxStockPercentage;
    private Double maxSectorPercentage;

    public RiskThreshold() {}

    public Long getId() { return id; }

    public Double getMaxStockPercentage() { return maxStockPercentage; }
    public void setMaxStockPercentage(Double maxStockPercentage) {
        this.maxStockPercentage = maxStockPercentage;
    }

    public Double getMaxSectorPercentage() { return maxSectorPercentage; }
    public void setMaxSectorPercentage(Double maxSectorPercentage) {
        this.maxSectorPercentage = maxSectorPercentage;
    }
}
