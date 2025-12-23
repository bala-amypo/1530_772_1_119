package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "portfolio_holdings")
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    @JsonIgnore
    private UserPortfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    @JsonIgnore
    private Stock stock;

    private Double quantity;

    private BigDecimal marketValue;

    public PortfolioHolding() {
    }

    public PortfolioHolding(UserPortfolio portfolio,
                            Stock stock,
                            Double quantity,
                            BigDecimal marketValue) {
        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }


    public Long getId() {
        return id;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public Stock getStock() {
        return stock;
    }

    public Double getQuantity() {
        return quantity;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }
}
