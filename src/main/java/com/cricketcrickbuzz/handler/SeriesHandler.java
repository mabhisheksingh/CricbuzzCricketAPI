package com.cricketcrickbuzz.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class SeriesHandler {
    @Value("${CRICK_BUZZ_BASE_URL}")
    private String baseURL;// ="https://cricbuzz-cricket.p.rapidapi.com";
    @Value("${keys.cricket.X-RapidAPI-Key}")
    private String cricketAPIKey;
    @Value("${keys.cricket.X-RapidAPI-Host}")
    private String cricketAPIHost;
    private WebClient webClient;
    private static final String S_SCHEDULE_V1 = "/series/v1/";
    private static final String S_NEWS_V1 = "/news/v1/";
    @PostConstruct
    private void init() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseURL)
                .defaultHeader("X-RapidAPI-Key", cricketAPIKey)
                .defaultHeader("X-RapidAPI-Host", cricketAPIHost)
                .build();
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('type')")
    public Mono<ServerResponse> getList(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("type");
        List<String> validType = Arrays.asList("international","league","domestic","women");
        if(!validType.contains(type))
            return ServerResponse.status(404).bodyValue("valid types  are request "+type);
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1 + type)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('type') + #serverRequest.pathVariable('archives')")
    public Mono<ServerResponse> listArchives(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("type");
        List<String> validType = Arrays.asList("international","league","domestic","women");
        if(!validType.contains(type))
            return ServerResponse.status(404).bodyValue("valid types  are request "+type);
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1 +"archives/"+ type)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId')")
    public Mono<ServerResponse> getMatches(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1 + type)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') + #serverRequest.pathVariable('news')")
    public Mono<ServerResponse> getNews(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri(S_NEWS_V1+"series/" + type)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') +'squads'")
    public Mono<ServerResponse> getSquads(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1+type+"/squads")
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') + #serverRequest.pathVariable('squadId')")
    public Mono<ServerResponse> getPlayers(ServerRequest serverRequest){
        String seriesId = serverRequest.pathVariable("seriesId");
        String squadId = serverRequest.pathVariable("squadId");
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1+seriesId+"/squads/"+ squadId)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') +'venues'")
    public Mono<ServerResponse> getVenue(ServerRequest serverRequest){
        String type = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri(S_SCHEDULE_V1+type+"/venues")
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }
    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') + #serverRequest.pathVariable('pointTable')")
    public Mono<ServerResponse> getPointTable(ServerRequest serverRequest){
        String seriesId = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri("stats/v1/series/"+seriesId+"/points-table")
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }

    @Cacheable(value = "series", key = "#serverRequest.pathVariable('seriesId') +'statsFilter'")
    public Mono<ServerResponse> getStatsFilter(ServerRequest serverRequest){
        String seriesId = serverRequest.pathVariable("seriesId");
        Mono<Object> res = webClient
                .get()
                .uri("stats/v1/series/"+seriesId)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }
}
