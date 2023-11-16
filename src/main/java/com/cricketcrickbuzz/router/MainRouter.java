package com.cricketcrickbuzz.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MainRouter {

    private CricketAPI cricketAPI;

    public MainRouter(CricketAPI cricketAPI) {
        this.cricketAPI = cricketAPI;
    }

    @Bean
    public RouterFunction<ServerResponse> mainRouters() {
        return RouterFunctions
                .route()
                .path("/api/v1", builder ->
                        builder.add(cricketAPI.cricketCrickBuzzAPI())
                )
                .build();
    }


}
