package com.cricketcrickbuzz.exception;

import com.cricketcrickbuzz.model.CustomError;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;
@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources,
                                          ApplicationContext applicationContext, ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, resources, applicationContext);
        this.setMessageReaders(serverCodecConfigurer.getReaders());
        this.setMessageWriters(serverCodecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }
    private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String,Object> errorProperties = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        System.out.println("ERROR handle "+errorProperties);
        CustomError customError = CustomError.builder()
                .path(errorProperties.get("path").toString())
                .timestamp(errorProperties.get("timestamp").toString())
                .Status(errorProperties.get("status").toString())
                .error(errorProperties.get("error").toString())
                .requestId(errorProperties.get("requestId").toString())
                .build();
        return ServerResponse
//                .status(HttpStatusCode.valueOf( Integer.valueOf(customError.getStatus() ) ))
                .status(HttpStatus.resolve(Integer.valueOf( customError.getStatus() )))
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(customError);
//                .body(BodyInserters.fromValue(errorProperties));
    }
}
