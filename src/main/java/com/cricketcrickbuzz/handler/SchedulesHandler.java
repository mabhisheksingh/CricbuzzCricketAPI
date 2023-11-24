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
public class SchedulesHandler {
    @Value("${CRICK_BUZZ_BASE_URL}")
    private String baseURL;// ="https://cricbuzz-cricket.p.rapidapi.com";
    @Value("${keys.cricket.X-RapidAPI-Key}")
    private String cricketAPIKey;
    @Value("${keys.cricket.X-RapidAPI-Host}")
    private String cricketAPIHost;
    private WebClient webClient;
    private static final String S_SCHEDULE_V1 = "/schedule/v1/";
    @PostConstruct
    private void init() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseURL)
                .defaultHeader("X-RapidAPI-Key", cricketAPIKey)
                .defaultHeader("X-RapidAPI-Host", cricketAPIHost)
                .build();
    }

    @Cacheable(value = "schedules", key = "#serverRequest.pathVariable('type')")
    public Mono<ServerResponse> getList(ServerRequest serverRequest){
        System.out.println("Hi Schedule Hit ... ");
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
}
