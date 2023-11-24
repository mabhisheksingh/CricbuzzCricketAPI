package com.cricketcrickbuzz.router;

import com.cricketcrickbuzz.handler.MatchesHandler;
import com.cricketcrickbuzz.handler.SchedulesHandler;
import com.cricketcrickbuzz.handler.SeriesHandler;
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
        private final MatchesHandler matchesHandler;
        private final SeriesHandler seriesHandler;
        private final SchedulesHandler schedulesHandler;

        public CricketAPI(MatchesHandler matchesHandler,
                        SeriesHandler seriesHandler,
                        SchedulesHandler schedulesHandler) {
                this.matchesHandler = matchesHandler;
                this.seriesHandler = seriesHandler;
                this.schedulesHandler = schedulesHandler;
        }

        public RouterFunction<ServerResponse> cricketCrickBuzzAPI() {
                return RouterFunctions.route()
                                .path("/matches", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list/{type}",
                                                                                                matchesHandler::getList)
                                                                                .GET("/get-info/{matchId}",
                                                                                                matchesHandler::getInfo)
                                                                                .GET("/get-team/{matchId}/{teamId}",
                                                                                                matchesHandler::getTeam)
                                                                                .GET("/get-commentaries/{matchId}",
                                                                                                matchesHandler::getCommentaries)
                                                                                .GET("/get-commentaries-v2/{matchId}",
                                                                                                matchesHandler::getCommentariesV2)
                                                                                .GET("/get-overs/{matchId}",
                                                                                                matchesHandler::getOvers)
                                                                                .GET("/get-scorecard/{matchId}",
                                                                                                matchesHandler::getScorecard)
                                                                                .GET("/get-scorecard-v2/{matchId}",
                                                                                                matchesHandler::getScorecardV2)
                                                                                .GET("/get-leanback/{matchId}",
                                                                                                matchesHandler::getLeanback)))
                                .path("/schedules", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list/{type}", schedulesHandler::getList)))
                                .path("/series", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list/{type}", seriesHandler::getList)
                                                                                .GET("/list-archives/{type}",
                                                                                                seriesHandler::listArchives)
                                                                                .GET("/get-matches/{seriesId}",
                                                                                                seriesHandler::getMatches)
                                                                                .GET("/get-news/{seriesId}",
                                                                                                seriesHandler::getNews)
                                                                                .GET("/get-squads/{seriesId}",
                                                                                                seriesHandler::getSquads)
                                                                                .GET("/get-players/{seriesId}/{squadId}",
                                                                                                seriesHandler::getPlayers)
                                                                                .GET("/get-venues/{seriesId}",
                                                                                                seriesHandler::getVenue)
                                                                                .GET("/get-points-table/{seriesId}",
                                                                                                seriesHandler::getPointTable)
                                                                                .GET("/get-stats-filters/{seriesId}",
                                                                                                seriesHandler::getPointTable)))
                                .path("/teams", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list", this::get)
                                                                                .GET("/get-schedules", this::get)
                                                                                .GET("/get-results", this::get)
                                                                                .GET("/get-news", this::get)
                                                                                .GET("/get-players", this::get)
                                                                                .GET("/get-stats-filters", this::get)
                                                                                .GET("/get-stats", this::get)))
                                .path("/venues", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/get-info", this::get)
                                                                                .GET("/get-stats", this::get)
                                                                                .GET("/get-matches", this::get)))
                                .path("/players", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list-trending", this::get)
                                                                                .GET("/get-career", this::get)
                                                                                .GET("/get-news", this::get)
                                                                                .GET("/get-bowling", this::get)
                                                                                .GET("/get-batting", this::get)
                                                                                .GET("/get-info", this::get)
                                                                                .GET("/search", this::get)))
                                .path("/news", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list", this::get)
                                                                                .GET("/detail", this::get)
                                                                                .GET("/get-categories", this::get)
                                                                                .GET("/list-by-category", this::get)
                                                                                .GET("/get-topics", this::get)
                                                                                .GET("/list-by-topic", this::get)))
                                .path("/photos", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/list", this::get)
                                                                                .GET("/get-gallery", this::get)
                                                                                .GET("/get-image", this::get)))
                                .path("/stats", builder -> builder
                                                .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
                                                                routerPath -> routerPath
                                                                                .GET("/get-icc-rankings", this::get)
                                                                                .GET("/get-icc-standings", this::get)
                                                                                .GET("/get-record-filters", this::get)
                                                                                .GET("/get-record", this::get)))
                                .filter(((request, next) -> {
                                        long startTime = System.currentTimeMillis();
                                        CustomLogger.logInRequest(request);
                                        return next.handle(request)
                                                        .doOnSuccess(result -> {
                                                                long endTime = System.currentTimeMillis();
                                                                Float executionTime = (endTime - startTime) / 1_000f;
                                                                logger.info("Log Id:{} Request path: {}, Execution time: {} ms",
                                                                                request.attributes().get(
                                                                                                "org.springframework.web.server.ServerWebExchange.LOG_ID"),
                                                                                request.attributes().get(
                                                                                                "org.springframework.web.reactive.function.server.RouterFunctions.matchingPattern"),
                                                                                executionTime);
                                                                CustomLogger.logOutRequest(request, result);
                                                        })
                                                        .doOnError(throwable -> {
                                                                long endTime = System.currentTimeMillis();
                                                                Float executionTime = (endTime - startTime) / 1_000f;
                                                                logger.info("Log Id:{} Request path: {}, Execution time: {} ms",
                                                                                request.attributes().get(
                                                                                                "org.springframework.web.server.ServerWebExchange.LOG_ID"),
                                                                                request.attributes().get(
                                                                                                "org.springframework.web.reactive.function.server.RouterFunctions.matchingPattern"),
                                                                                executionTime);
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
