package com.cricketcrickbuzz.router;

import com.cricketcrickbuzz.handler.MatchesHandler;
import com.cricketcrickbuzz.utils.CustomLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class CricketAPI {
    Logger logger = LoggerFactory.getLogger(CricketAPI.class);
    private MatchesHandler matchesHandler;

    public CricketAPI(MatchesHandler matchesHandler) {
        this.matchesHandler = matchesHandler;
    }


    public RouterFunction<ServerResponse> cricketCrickBuzzAPI() {
        return RouterFunctions.route()
                .path("/matches", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list/{type}", matchesHandler::getList)
                                        .GET("/get-info", this::get)
                                        .GET("/get-team", this::get)
                                        .GET("/get-commentaries", this::get)
                                        .GET("/get-overs", this::get)
                                        .GET("/get-scorecard", this::get)
                                        .GET("/get-scorecard-v2", this::get)
                                        .GET("/get-scorecard-v2", this::get)
                                        .GET("/get-leanback", this::get)
                        )
                )
                .path("/schedules", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list", this::get)
                        )
                )
                .path("/series", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list", this::get)
                                        .GET("/list-archives", this::get)
                                        .GET("/get-matches", this::get)
                                        .GET("/get-news", this::get)
                                        .GET("/get-squads", this::get)
                                        .GET("/get-players", this::get)
                                        .GET("/get-venues", this::get)
                                        .GET("/get-points-table", this::get)
                                        .GET("/get-stats-filters", this::get)
                                        .GET("/get-stats", this::get)
                        )
                )
                .path("/teams", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list", this::get)
                                        .GET("/get-schedules", this::get)
                                        .GET("/get-results", this::get)
                                        .GET("/get-news", this::get)
                                        .GET("/get-players", this::get)
                                        .GET("/get-stats-filters", this::get)
                                        .GET("/get-stats", this::get)
                        )
                )
                .path("/venues", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/get-info", this::get)
                                        .GET("/get-stats", this::get)
                                        .GET("/get-matches", this::get)
                        )
                )
                .path("/players", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list-trending", this::get)
                                        .GET("/get-career", this::get)
                                        .GET("/get-news", this::get)
                                        .GET("/get-bowling", this::get)
                                        .GET("/get-batting", this::get)
                                        .GET("/get-info", this::get)
                                        .GET("/search", this::get)
                        )
                )
                .path("/news", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list", this::get)
                                        .GET("/detail", this::get)
                                        .GET("/get-categories", this::get)
                                        .GET("/list-by-category", this::get)
                                        .GET("/get-topics", this::get)
                                        .GET("/list-by-topic", this::get)
                        )
                )
                .path("/photos", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/list", this::get)
                                        .GET("/get-gallery", this::get)
                                        .GET("/get-image", this::get)
                        )
                )
                .path("/stats", builder -> builder
                        .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), routerPath ->
                                routerPath
                                        .GET("/get-icc-rankings", this::get)
                                        .GET("/get-icc-standings", this::get)
                                        .GET("/get-record-filters", this::get)
                                        .GET("/get-record", this::get)
                        )
                ).filter(((request, next) -> {
                    long startTime = System.currentTimeMillis();
                    CustomLogger.logInRequest(request);
                    return next.handle(request)
                            .doOnSuccess(result -> {
                                long endTime = System.currentTimeMillis();
                                Float executionTime = (endTime - startTime)/1_000f;
                                logger.info("Request path: {}, Execution time: {} ms", request.exchange().getRequest(), executionTime);
                                CustomLogger.logOutRequest(request, result);
                            })
                            .doOnError(throwable -> {
                                long endTime = System.currentTimeMillis();
                                Float executionTime = (endTime - startTime)/1_000f;
                                logger.info("M Request path: {}, Execution time: {} ms", request.exchange().getRequest(), executionTime);
                                CustomLogger.logOutRequest(request, throwable);
                            });
                }))

                .build();
    }


    private Mono<ServerResponse> get(ServerRequest sr) {
        return ServerResponse
                .ok()
                .bodyValue("sas");
    }

}
