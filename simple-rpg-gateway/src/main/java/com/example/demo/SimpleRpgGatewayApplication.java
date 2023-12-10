package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
								"/api/boaTypes/{uuid}",
								"/api/boatTypes"
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
}
