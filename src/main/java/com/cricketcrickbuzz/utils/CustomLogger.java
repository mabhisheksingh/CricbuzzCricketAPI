package com.cricketcrickbuzz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

public class CustomLogger {
    private static Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public static void logInRequest(ServerRequest sr){
        //[org.springframework.web.reactive.function.server.RouterFunctions.uriTemplateVariables,
        // org.springframework.web.reactive.HandlerMapping.bestMatchingHandler,
        // org.springframework.web.reactive.HandlerMapping.bestMatchingPattern,
        // org.springframework.web.reactive.function.server.RouterFunctions.request,
        // org.springframework.web.reactive.HandlerMapping.uriTemplateVariables, org.springframework.web.server.ServerWebExchange.LOG_ID,
        // org.springframework.web.reactive.function.server.RouterFunctions.matchingPattern]
        logger.info("Id: {}, URL PATH {}, Http headers {}, path variables {}, calling method  {}, matchingPattern :{} ",sr.attributes().get("org.springframework.web.server.ServerWebExchange.LOG_ID"),sr.path(),sr.headers(),
                sr.pathVariables(), sr.method() ,sr.attributes().get("org.springframework.web.reactive.function.server.RouterFunctions.matchingPattern") );
        logger.info(sr.attributes().toString());
    }
    public static void logOutRequest(ServerRequest serverRequest, ServerResponse sr){
        logger.info("Id: {}, response status code {}, Http headers {}, path variables {}",serverRequest.attributes().get("org.springframework.web.server.ServerWebExchange.LOG_ID"),sr.statusCode(),sr.headers(), sr.toString() );
//        logger.info(sr.toString());
//        logger.info(serverRequest.);
    }
}
