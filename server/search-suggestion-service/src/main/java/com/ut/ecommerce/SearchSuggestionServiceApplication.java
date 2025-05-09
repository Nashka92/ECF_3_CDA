package com.ut.ecommerce;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchSuggestionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SearchSuggestionServiceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("✅ SearchSuggestionController chargé !");
	}
}

