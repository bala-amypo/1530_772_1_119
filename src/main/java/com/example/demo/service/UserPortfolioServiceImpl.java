package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolio;
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return null;
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return List.of();
    }
}
