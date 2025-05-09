package com.ut.ecommerce.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchSuggestionController {

    private final RestTemplate restTemplate;
    private final String commonDataServiceUrl;

    public SearchSuggestionController(RestTemplate restTemplate,
                                      @Value("${common.data.service.url}") String commonDataServiceUrl) {
        this.restTemplate = restTemplate;
        this.commonDataServiceUrl = commonDataServiceUrl;
    }

    @GetMapping("/default-search-suggestion")
    public ResponseEntity<?> getSuggestions() {
        String url = commonDataServiceUrl + "/search-suggestion-list";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}