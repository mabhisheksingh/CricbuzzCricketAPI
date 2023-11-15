package com.cricketcrickbuzz.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MainRouter {
    @Autowired
    private CricketAPI cricketAPI;
//    public MainRouter(CricketAPI cricketAPI){
//        this.cricketAPI= cricketAPI;
//    }
    @Bean
    public RouterFunction<ServerResponse> mainRouters(){
        return RouterFunctions.route().path("api/v1", builder ->
                        builder.add(cricketAPI.matches())
                )
                .build();
    }

    
}
