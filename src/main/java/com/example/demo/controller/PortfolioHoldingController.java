package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public PortfolioHolding create(@RequestBody PortfolioHolding holding) {
        return holdingService.createHolding(holding);
    }

    @PutMapping("/{id}")
    public PortfolioHolding update(@PathVariable Long id,
                                   @RequestBody PortfolioHolding holding) {
        return holdingService.updateHolding(id, holding);
    }

    @GetMapping("/{id}")
    public PortfolioHolding getById(@PathVariable Long id) {
        return holdingService.getHoldingById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getByPortfolio(
            @PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    holdingService.deleteHolding(id);
    }
}
