package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_portfolios")
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(nullable = false)
    private String portfolioName;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio")
    @JsonIgnore
    private List<PortfolioHolding> holdings;

    @OneToMany(mappedBy = "portfolio")
    @JsonIgnore
    private List<RiskAnalysisResult> analyses;

    public UserPortfolio() {
    }

    public UserPortfolio(User user, String portfolioName, LocalDateTime createdAt) {
        this.user = user;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<PortfolioHolding> getHoldings() {
        return holdings;
    }

    public List<RiskAnalysisResult> getAnalyses() {
        return analyses;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setHoldings(List<PortfolioHolding> holdings) {
        this.holdings = holdings;
    }

    public void setAnalyses(List<RiskAnalysisResult> analyses) {
        this.analyses = analyses;
    }
}
