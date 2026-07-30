package com.example.spring_rest_handson;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CountryController {

    private List<Country> getCountryList() {
        List<Country> countries = new ArrayList<>();
        countries.add(make("India", "IN"));
        countries.add(make("United States", "US"));
        countries.add(make("Japan", "JP"));
        countries.add(make("Germany", "DE"));
        return countries;
    }

    private Country make(String name, String code) {
        Country c = new Country();
        c.setName(name);
        c.setCode(code);
        return c;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return getCountryList();
    }
    @GetMapping("/countries/{code}")
public Country getCountryByCode(@PathVariable String code) {
    return getCountryList().stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
}
}