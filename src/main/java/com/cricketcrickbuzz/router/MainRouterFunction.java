package com.cricketcrickbuzz.router;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MainRouterFunction {

    private final CricketAPI cricketAPI;

    public MainRouterFunction(CricketAPI cricketAPI) {
        this.cricketAPI = cricketAPI;
    }

    @Bean
    public RouterFunction<ServerResponse> routers() {
        return RouterFunctions
                .route()
                .path("/api/v1", builder ->
                        builder.add(cricketAPI.cricketCrickBuzzAPI())
                )
                .build();
    }


}
