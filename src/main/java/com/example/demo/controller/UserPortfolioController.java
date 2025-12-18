package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    @PostMapping
    public UserPortfolio add(@RequestBody UserPortfolio p) {
        return service.createPortfolio(p);
    }

    @GetMapping("/{id}")
    public UserPortfolio get(@PathVariable Long id) {
        return service.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> byUser(@PathVariable Long userId) {
        return service.getPortfoliosByUser(userId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivatePortfolio(id);
    }
}
