package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService {

    PortfolioHolding createHolding(PortfolioHolding h);
    List<PortfolioHolding> getByPortfolio(Long portfolioId);
}
