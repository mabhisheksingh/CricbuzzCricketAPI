package com.cricketcrickbuzz.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MatchesHandler {

    @Value("${CRICK_BUZZ_BASE_URL}")
    private String baseURL;// ="https://cricbuzz-cricket.p.rapidapi.com";
    @Value("${keys.cricket.X-RapidAPI-Key}")
    private String cricketAPIKey;
    @Value("${keys.cricket.X-RapidAPI-Host}")
    private String cricketAPIHost;
    private WebClient webClient;

    private static final String M_CENTER_V1 = "/mcenter/v1/";

    @PostConstruct
    public void init() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseURL)
                .defaultHeader("X-RapidAPI-Key", cricketAPIKey)
                .defaultHeader("X-RapidAPI-Host", cricketAPIHost)
                .build();
    }

    @Cacheable(value = "matches", key = "#serverRequest.pathVariable('type')")
    public Mono<ServerResponse> getList(ServerRequest serverRequest) {
        String type = serverRequest.pathVariable("type");
        List<String> validType = Arrays.asList("live","recent","upcoming");
        if(!validType.contains(type))
            return ServerResponse.status(404).bodyValue("valid types  are request "+type);
        Mono<Object> res = webClient
                .get()
                .uri("/matches/v1/" + type)
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r ->ServerResponse.ok().bodyValue(r));
    }


    @Cacheable(value = "matches", key = "#serverRequest.pathVariable('matchId')")
    public Mono<ServerResponse> getInfo(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Mono<Object> res = webClient
                .get()
                .uri(M_CENTER_V1 + matchId)
                .retrieve()
                .bodyToMono(Object.class);
        return res
                .flatMap( response ->ServerResponse.ok().bodyValue( response ))
                .cache();
    }


    @Cacheable(value = "matches", key = "#serverRequest.pathVariable('matchId') + #serverRequest.pathVariable('teamId')")
    public Mono<ServerResponse> getTeam(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        String teamId = serverRequest.pathVariable("teamId");
        Mono<String> res = webClient
                .get()
                .uri(M_CENTER_V1 + matchId + File.separator + "team" + File.separator + teamId )
                .header("X-RapidAPI-Key", cricketAPIKey)
                .header("X-RapidAPI-Host", cricketAPIHost)
                .retrieve()
                .bodyToMono(String.class);
        return res
                .flatMap(r -> ServerResponse.ok().bodyValue(r));

    }

    @Cacheable(value = "matches", key = "#serverRequest.pathVariable('matchId') + #serverRequest.pathVariable('iid') + #serverRequest.pathVariable('tms')")
    public Mono<ServerResponse> getCommentaries(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Optional<String> iid = serverRequest.queryParam("iid");
        Optional<String> tms = serverRequest.queryParam("tms");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId+ File.separator+ "comm")
                        .queryParamIfPresent("iid", iid)
                        .queryParamIfPresent("tms", tms)
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }

    public Mono<ServerResponse> getCommentariesV2(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Optional<String> iid = serverRequest.queryParam("iid");
        Optional<String> tms = serverRequest.queryParam("tms");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId + File.separator +"hcomm")
                        .queryParamIfPresent("iid", iid)
                        .queryParamIfPresent("tms", tms)
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }
    public Mono<ServerResponse> getOvers(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Optional<String> iid = serverRequest.queryParam("iid");
        Optional<String> tms = serverRequest.queryParam("tms");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId+ File.separator + "overs")
                        .queryParamIfPresent("iid", iid)
                        .queryParamIfPresent("tms", tms)
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }
    public Mono<ServerResponse> getScorecard(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId +File.separator+ "scard")
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }
    public Mono<ServerResponse> getScorecardV2(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId + File.separator+"hscard")
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }
    public Mono<ServerResponse> getLeanback(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        Mono<Object> res = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(M_CENTER_V1 + matchId + File.separator + "leanback")
                        .build()
                )
                .retrieve()
                .bodyToMono(Object.class);
        return res.flatMap(r -> ServerResponse.ok().bodyValue(r));
    }

}
