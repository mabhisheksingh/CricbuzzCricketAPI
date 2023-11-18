package com.cricketcrickbuzz.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class GlobalExecutionTimeFilter implements WebFilter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExecutionTimeFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();
        return chain.filter(exchange).doFinally(signal -> {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            logger.info("Request path: {}, Execution time: {} ms", exchange.getRequest().getPath(), executionTime);
        });
    }
}