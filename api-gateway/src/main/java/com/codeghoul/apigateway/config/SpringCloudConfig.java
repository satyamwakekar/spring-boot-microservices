package com.codeghoul.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

  @Bean
  public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            r ->
                r.path("/users/**")
                    .filters(
                        f ->
                            f.hystrix(
                                h ->
                                    h.setName("Hystrix")
                                        .setFallbackUri("forward:/user-service-fallback")))
                    .uri("lb://USERSERVICE")
                    .id("USERSERVICE"))
        .route(
            r ->
                r.path("/departments/**")
                    .filters(
                        f ->
                            f.hystrix(
                                h ->
                                    h.setName("Hystrix")
                                        .setFallbackUri("forward:/department-service-fallback")))
                    .uri("lb://DEPARTMENTSERVICE")
                    .id("DEPARTMENTSERVICE"))
        .build();
  }
}
