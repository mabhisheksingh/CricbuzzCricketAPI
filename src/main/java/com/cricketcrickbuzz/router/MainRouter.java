package com.cricketcrickbuzz.router;

import com.cricketcrickbuzz.dto.Coffee;
import com.cricketcrickbuzz.handler.CoffeeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MainRouter {

    private final CricketAPI cricketAPI;
    private final CoffeeHandler coffeeHandler;

    public MainRouter(CricketAPI cricketAPI, CoffeeHandler coffeeHandler) {
        this.cricketAPI = cricketAPI;
        this.coffeeHandler = coffeeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> mainRouters() {
        return RouterFunctions
                .route()
                .GET("/coffees", req -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(coffeeHandler.allCoffee(req), Coffee.class))
                .path("/api/v1", builder ->
                        builder.add(cricketAPI.cricketCrickBuzzAPI())
                )
                .build();
    }


}
