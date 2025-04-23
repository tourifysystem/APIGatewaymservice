package bt.edu.gcit.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user-service", r -> r.path("/api/users/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://USER-SERVICE"))
            .route("auth-service", r -> r.path("/auth/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://AUTH-SERVICE"))
            .build();
    }
}