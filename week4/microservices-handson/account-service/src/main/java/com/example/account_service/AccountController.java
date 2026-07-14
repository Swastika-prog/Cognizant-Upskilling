package com.example.account_service;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts")
    public List<Map<String, Object>> getAccounts() {
        return List.of(
            Map.of("number", "ACC1001", "type", "savings", "balance", 55000),
            Map.of("number", "ACC1002", "type", "current", "balance", 120000)
        );
    }
}