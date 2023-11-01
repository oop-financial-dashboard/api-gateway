package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authenticationRoute", routeSpec -> routeSpec
                        .path("**/api/users/**")
                        .uri("http://localhost:8081/")
                )
                .build();

    }

}
