package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;



@SpringBootApplication
public class SimpleRpgGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRpgGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${rpg.boat.url}") String boatUrl,
			@Value("${rpg.boatType.url}") String boatTypeUrl,
			@Value("${rpg.gatewy.host}") String host
	) {
		return builder
				.routes()
				.route("boatTypes", route -> route
						.host(host)
						.and()
						.path(
								"/api/boatTypes/{uuid}",
								"/api/boatTypes",
								"/api/boatTypes/**"
						)
						.uri(boatTypeUrl)
				)
				.route("boats", route -> route
						.host(host)
						.and()
						.path(
								"/api/boats",
								"/api/boats/**",
								"/api/boatTypes/{uuid}/boats",
								"/api/boatTypes/{uuid}/boats/**"
						)
						.uri(boatUrl)
				)
				.build();
	}
	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
