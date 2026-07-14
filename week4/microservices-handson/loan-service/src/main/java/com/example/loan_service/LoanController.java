package com.example.loan_service;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loans")
    public List<Map<String, Object>> getLoans() {
        return List.of(
            Map.of("id", "LN2001", "type", "home", "amount", 2500000),
            Map.of("id", "LN2002", "type", "car", "amount", 800000)
        );
    }
}