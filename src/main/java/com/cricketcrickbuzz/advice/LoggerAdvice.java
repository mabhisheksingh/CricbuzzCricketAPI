package com.cricketcrickbuzz.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Aspect
@Component
public class LoggerAdvice {
    Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

    @Around("@annotation(com.cricketcrickbuzz.advice.TrackMethodExecutionTime)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        if (proceed instanceof Mono) {
            return ((Mono<?>) proceed)
                    .doOnSuccess(result -> {
                        long executionTime = System.currentTimeMillis() - startTime;
                        logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime/1_000f);
                    })
                    .doOnError(throwable -> {
                        long executionTime = System.currentTimeMillis() - startTime;
                        logger.error("{} execution failed in {} ms with error: {}", joinPoint.getSignature(), executionTime, throwable.getMessage());
                    });
        } else {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime/1_000f);

            return proceed;
        }
    }

}
