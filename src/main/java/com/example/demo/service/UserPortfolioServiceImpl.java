package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repo;

    public UserPortfolioServiceImpl(UserPortfolioRepository repo) {
        this.repo = repo;
    }

    public UserPortfolio createPortfolio(UserPortfolio p) {
        return repo.save(p);
    }

    public UserPortfolio updatePortfolio(Long id, UserPortfolio p) {
        UserPortfolio e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        e.setPortfolioName(p.getPortfolioName());
        return repo.save(e);
    }

    public UserPortfolio getPortfolioById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public void deactivatePortfolio(Long id) {
        UserPortfolio e = getPortfolioById(id);
        e.setActive(false);
        repo.save(e);
    }
}
