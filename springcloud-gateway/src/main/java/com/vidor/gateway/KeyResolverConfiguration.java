package com.vidor.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfiguration {

    @Bean
    public KeyResolver pathKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    @Bean
    public KeyResolver paramKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("serviceId"));
        //IP限流
        //return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("X-Forwarded-For"));
    }
}
