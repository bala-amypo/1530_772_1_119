package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public PortfolioHolding add(@RequestBody PortfolioHolding h) {
        return service.createHolding(h);
    }

    @GetMapping("/portfolio/{id}")
    public List<PortfolioHolding> get(@PathVariable Long id) {
        return service.getByPortfolio(id);
    }
}
