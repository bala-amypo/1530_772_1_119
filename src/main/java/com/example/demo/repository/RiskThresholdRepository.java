package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RiskThreshold;

public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {

    RiskThreshold findByActiveTrue(); 
}
