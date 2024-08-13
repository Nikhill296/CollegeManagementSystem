package com.college.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

	@Bean
	RestClient getUserServiceRestclient() {
		return RestClient.builder()
					.baseUrl("http://localhost:8090/")
					.defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
					.build();
	}
}
