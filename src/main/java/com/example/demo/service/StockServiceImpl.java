package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    public Stock createStock(Stock stock) {

        if (repository.findByTicker(stock.getTicker()).isPresent()) {
            throw new IllegalArgumentException("Duplicate ticker");
        }

        stock.setIsActive(true);
        return repository.save(stock);
    }

    public Stock updateStock(Long id, Stock stock) {
        Stock existing = getStockById(id);
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        return repository.save(existing);
    }

    public Stock getStockById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    public void deactivateStock(Long id) {
        Stock stock = getStockById(id);
        stock.setIsActive(false);
        repository.save(stock);
    }
}
