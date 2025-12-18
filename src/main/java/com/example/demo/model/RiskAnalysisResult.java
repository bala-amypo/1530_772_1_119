package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
    private LocalDateTime analysisDate;

    public RiskAnalysisResult() {}

    // getters and setters
}
