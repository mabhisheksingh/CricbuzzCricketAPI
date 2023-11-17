package com.cricketcrickbuzz.handler;

import com.cricketcrickbuzz.dto.Coffee;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoffeeHandler {
    private final ReactiveRedisOperations<String, Coffee> coffeeOps;

    CoffeeHandler(ReactiveRedisOperations<String, Coffee> coffeeOps) {
        this.coffeeOps = coffeeOps;
    }

    public Flux<Coffee> allCoffee(ServerRequest serverRequest){

//        return ServerResponse.ok().bodyValue("AA");
        return coffeeOps.keys("*").flatMap(coffeeOps.opsForValue()::get);
    }

}
