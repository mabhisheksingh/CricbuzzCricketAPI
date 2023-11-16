package com.cricketcrickbuzz.handler;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Service
public class MatchesHandler {

    @Value("${CRICK_BUZZ_BASE_URL}")
    private String baseURL;//="https://cricbuzz-cricket.p.rapidapi.com";
    @Value("${keys.cricket.X-RapidAPI-Key}")
    private String cricketAPIKey;
    @Value("${keys.cricket.X-RapidAPI-Host}")
    private String cricketAPIHost;
    private WebClient webClient;

    @PostConstruct
    public void init(){
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }
//    OkHttpClient client = new OkHttpClient();
//
//    Request request = new Request.Builder()
//            .url("https://cricbuzz-cricket.p.rapidapi.com/matches/v1/live")
//            .get()
//            .addHeader("X-RapidAPI-Key", "488a1af9edmsh4edb03197cbf363p16bfd8jsna6633427e868")
//            .addHeader("X-RapidAPI-Host", "cricbuzz-cricket.p.rapidapi.com")
//            .build();
//
//    Response response = client.newCall(request).execute();
    public Mono<ServerResponse>  getList(ServerRequest serverRequest){
        List<String> supportParameterList = Arrays.asList("live","recent","upcoming");
        String type = serverRequest.pathVariable("type");
        if( !supportParameterList.contains( type ) ){
            return ServerResponse.badRequest().bodyValue("Supported path were "+ supportParameterList);
        }
//        System.out.println("Type : "+type);
         Mono<Object> res =webClient
                .get()
                .uri("/matches/v1/"+type)
                .header("X-RapidAPI-Key", cricketAPIKey)
                .header("X-RapidAPI-Host", cricketAPIHost)
                .retrieve()
                .bodyToMono(Object.class);
        return res
                .flatMap( r ->ServerResponse.ok().bodyValue(r));

    }
}
