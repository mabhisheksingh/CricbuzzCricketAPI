package com.cricketcrickbuzz.router;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class CricketAPI {
    public RouterFunction<ServerResponse> matches(){
        return RouterFunctions.route()
                .path("/matches", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list",this::tger )
                                        .GET("/get-info",this::tger )
                                        .GET("/get-team",this::tger )
                                        .GET("/get-commentaries",this::tger )
                                        .GET("/get-overs",this::tger )
                                        .GET("/get-scorecard",this::tger )
                                        .GET("/get-scorecard-v2",this::tger )
                                        .GET("/get-scorecard-v2",this::tger )
                                        .GET("/get-leanback",this::tger )
                        )
                ).path("/schedules", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("", this::tger)
                        )
                )

                .build();
    }

    RouterFunction<ServerResponse> schedules(ServerRequest sr){
        return RouterFunctions.route()
                .GET("/list",this::tger )
                .build();
    }

    private Mono<ServerResponse> tger(ServerRequest sr){
        return ServerResponse
                .ok()
                .bodyValue( "sas");
    }
    


}
