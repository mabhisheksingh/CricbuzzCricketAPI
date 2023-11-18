# CricbuzzCricketAPI
Cricbuzz Cricket API is built on reactive Spring boot Web-flux is api URL is [Rapid API URL for crickbuzz](https://rapidapi.com/cricketapilive/api/cricbuzz-cricket)

## here i am using crick buzz api and in place of model i am using Object class as a DTO global logging and exception handling already implemented


### Bug in docker compose working only spring boot > 3.1.5 because when u will use docker compose in 3.1.5 u will get below error.
```powershell
"C:\Program Files\Java\jdk-17.0.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar=58998:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Code\java\CricbuzzCricketAPI\target\classes;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-webflux\3.1.5\spring-boot-starter-webflux-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter\3.1.5\spring-boot-starter-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.1.5\spring-boot-starter-logging-3.1.5.jar;C:\Users\abhis\.m2\repository\ch\qos\logback\logback-classic\1.4.11\logback-classic-1.4.11.jar;C:\Users\abhis\.m2\repository\ch\qos\logback\logback-core\1.4.11\logback-core-1.4.11.jar;C:\Users\abhis\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.20.0\log4j-to-slf4j-2.20.0.jar;C:\Users\abhis\.m2\repository\org\apache\logging\log4j\log4j-api\2.20.0\log4j-api-2.20.0.jar;C:\Users\abhis\.m2\repository\org\slf4j\jul-to-slf4j\2.0.9\jul-to-slf4j-2.0.9.jar;C:\Users\abhis\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\abhis\.m2\repository\org\yaml\snakeyaml\1.33\snakeyaml-1.33.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-json\3.1.5\spring-boot-starter-json-3.1.5.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.15.3\jackson-datatype-jdk8-2.15.3.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.15.3\jackson-datatype-jsr310-2.15.3.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-reactor-netty\3.1.5\spring-boot-starter-reactor-netty-3.1.5.jar;C:\Users\abhis\.m2\repository\io\projectreactor\netty\reactor-netty-http\1.1.12\reactor-netty-http-1.1.12.jar;C:\Users\abhis\.m2\repository\io\netty\netty-codec-http\4.1.100.Final\netty-codec-http-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-buffer\4.1.100.Final\netty-buffer-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-codec\4.1.100.Final\netty-codec-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-codec-http2\4.1.100.Final\netty-codec-http2-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-resolver-dns\4.1.100.Final\netty-resolver-dns-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-resolver\4.1.100.Final\netty-resolver-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-codec-dns\4.1.100.Final\netty-codec-dns-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-resolver-dns-native-macos\4.1.100.Final\netty-resolver-dns-native-macos-4.1.100.Final-osx-x86_64.jar;C:\Users\abhis\.m2\repository\io\netty\netty-resolver-dns-classes-macos\4.1.100.Final\netty-resolver-dns-classes-macos-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-transport-native-epoll\4.1.100.Final\netty-transport-native-epoll-4.1.100.Final-linux-x86_64.jar;C:\Users\abhis\.m2\repository\io\netty\netty-transport-native-unix-common\4.1.100.Final\netty-transport-native-unix-common-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-transport-classes-epoll\4.1.100.Final\netty-transport-classes-epoll-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\projectreactor\netty\reactor-netty-core\1.1.12\reactor-netty-core-1.1.12.jar;C:\Users\abhis\.m2\repository\io\netty\netty-handler-proxy\4.1.100.Final\netty-handler-proxy-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-codec-socks\4.1.100.Final\netty-codec-socks-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-web\6.0.13\spring-web-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-beans\6.0.13\spring-beans-6.0.13.jar;C:\Users\abhis\.m2\repository\io\micrometer\micrometer-observation\1.11.5\micrometer-observation-1.11.5.jar;C:\Users\abhis\.m2\repository\io\micrometer\micrometer-commons\1.11.5\micrometer-commons-1.11.5.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-webflux\6.0.13\spring-webflux-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-docker-compose\3.1.5\spring-boot-docker-compose-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot\3.1.5\spring-boot-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-context\6.0.13\spring-context-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-aop\6.0.13\spring-aop-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-expression\6.0.13\spring-expression-6.0.13.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.15.3\jackson-databind-2.15.3.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.15.3\jackson-annotations-2.15.3.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.15.3\jackson-core-2.15.3.jar;C:\Users\abhis\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.15.3\jackson-module-parameter-names-2.15.3.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-data-redis-reactive\3.1.5\spring-boot-starter-data-redis-reactive-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-starter-data-redis\3.1.5\spring-boot-starter-data-redis-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\data\spring-data-redis\3.1.5\spring-data-redis-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\data\spring-data-keyvalue\3.1.5\spring-data-keyvalue-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\data\spring-data-commons\3.1.5\spring-data-commons-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-tx\6.0.13\spring-tx-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-oxm\6.0.13\spring-oxm-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-context-support\6.0.13\spring-context-support-6.0.13.jar;C:\Users\abhis\.m2\repository\io\lettuce\lettuce-core\6.2.6.RELEASE\lettuce-core-6.2.6.RELEASE.jar;C:\Users\abhis\.m2\repository\io\netty\netty-common\4.1.100.Final\netty-common-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-handler\4.1.100.Final\netty-handler-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\io\netty\netty-transport\4.1.100.Final\netty-transport-4.1.100.Final.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-devtools\3.1.5\spring-boot-devtools-3.1.5.jar;C:\Users\abhis\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.1.5\spring-boot-autoconfigure-3.1.5.jar;C:\Users\abhis\.m2\repository\org\slf4j\slf4j-api\2.0.9\slf4j-api-2.0.9.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-core\6.0.13\spring-core-6.0.13.jar;C:\Users\abhis\.m2\repository\org\springframework\spring-jcl\6.0.13\spring-jcl-6.0.13.jar;C:\Users\abhis\.m2\repository\io\projectreactor\reactor-core\3.5.11\reactor-core-3.5.11.jar;C:\Users\abhis\.m2\repository\org\reactivestreams\reactive-streams\1.0.4\reactive-streams-1.0.4.jar;C:\Users\abhis\.m2\repository\org\projectlombok\lombok\1.18.30\lombok-1.18.30.jar com.cricketcrickbuzz.CricketCrickBuzzApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.5)

2023-11-17T15:41:16.292+05:30  INFO 6020 --- [  restartedMain] c.c.CricketCrickBuzzApplication          : Starting CricketCrickBuzzApplication using Java 17.0.1 with PID 6020 (D:\Code\java\CricbuzzCricketAPI\target\classes started by abhishek in D:\Code\java\CricbuzzCricketAPI)
2023-11-17T15:41:16.302+05:30 DEBUG 6020 --- [  restartedMain] c.c.CricketCrickBuzzApplication          : Running with Spring Boot v3.1.5, Spring v6.0.13
2023-11-17T15:41:16.305+05:30  INFO 6020 --- [  restartedMain] c.c.CricketCrickBuzzApplication          : No active profile set, falling back to 1 default profile: "default"
2023-11-17T15:41:16.523+05:30  INFO 6020 --- [  restartedMain] .s.b.d.c.l.DockerComposeLifecycleManager : Using Docker Compose file 'D:\Code\java\CricbuzzCricketAPI\docker-compose.yml'
2023-11-17T15:41:21.761+05:30  INFO 6020 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container my-redis-container_name  Created
2023-11-17T15:41:21.777+05:30  INFO 6020 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container my-redis-container_name  Starting
2023-11-17T15:41:22.500+05:30  INFO 6020 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container my-redis-container_name  Started
2023-11-17T15:41:22.502+05:30  INFO 6020 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container my-redis-container_name  Waiting
2023-11-17T15:41:23.032+05:30  INFO 6020 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container my-redis-container_name  Healthy
2023-11-17T15:41:24.550+05:30 ERROR 6020 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

java.lang.NullPointerException: Cannot invoke "org.springframework.boot.docker.compose.core.DockerCliInspectResponse.hostConfig()" because "inspectResponse" is null
	at org.springframework.boot.docker.compose.core.DefaultConnectionPorts.isHostNetworkMode(DefaultConnectionPorts.java:56) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.core.DefaultConnectionPorts.<init>(DefaultConnectionPorts.java:47) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.core.DefaultRunningService.<init>(DefaultRunningService.java:55) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.core.DefaultDockerCompose.getRunningServices(DefaultDockerCompose.java:83) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.lifecycle.DockerComposeLifecycleManager.start(DockerComposeLifecycleManager.java:123) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.lifecycle.DockerComposeListener.onApplicationEvent(DockerComposeListener.java:53) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.boot.docker.compose.lifecycle.DockerComposeListener.onApplicationEvent(DockerComposeListener.java:35) ~[spring-boot-docker-compose-3.1.5.jar:3.1.5]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:174) ~[spring-context-6.0.13.jar:6.0.13]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:167) ~[spring-context-6.0.13.jar:6.0.13]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:145) ~[spring-context-6.0.13.jar:6.0.13]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:133) ~[spring-context-6.0.13.jar:6.0.13]
	at org.springframework.boot.context.event.EventPublishingRunListener.multicastInitialEvent(EventPublishingRunListener.java:136) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.context.event.EventPublishingRunListener.contextLoaded(EventPublishingRunListener.java:98) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplicationRunListeners.lambda$contextLoaded$4(SpringApplicationRunListeners.java:72) ~[spring-boot-3.1.5.jar:3.1.5]
	at java.base/java.lang.Iterable.forEach(Iterable.java:75) ~[na:na]
	at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:118) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:112) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplicationRunListeners.contextLoaded(SpringApplicationRunListeners.java:72) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplication.prepareContext(SpringApplication.java:420) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1306) ~[spring-boot-3.1.5.jar:3.1.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1295) ~[spring-boot-3.1.5.jar:3.1.5]
	at com.cricketcrickbuzz.CricketCrickBuzzApplication.main(CricketCrickBuzzApplication.java:16) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.1.5.jar:3.1.5]


Process finished with exit code 0

```

## Implement centralized logging
### We can implement it at method level with the help of Spring AOP and custom annotation with the help of below example.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
#### Creating custom annotation for Logging

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
@Retention(RetentionPolicy.RUNTIME) specifies the retention policy of the annotation. In this case, it indicates that the annotation information should be available at 
runtime through reflection (useful for runtime processing).
@Target({ElementType.METHOD, ElementType.TYPE}) specifies the valid targets for the custom annotation. In this example, the CustomAnnotation can be applied to 
methods (ElementType.METHOD) and types/classes (ElementType.TYPE).
The ElementType enum provides several constants representing various program elements to which annotations may be applied. Some common types include:

ElementType.TYPE: Annotation can be applied to classes, interfaces, enums, etc.
ElementType.FIELD: Annotation can be applied to fields (member variables).
ElementType.METHOD: Annotation can be applied to methods.
ElementType.PARAMETER: Annotation can be applied to method parameters.
And more, like PACKAGE, CONSTRUCTOR, LOCAL_VARIABLE, and ANNOTATION_TYPE.
For instance, by specifying @Target(ElementType.METHOD), you limit your custom annotation to only be used on methods, while @Target(ElementType.TYPE) restricts 
it to class-level usage. Multiple types can be specified within the @Target annotation using an array, as demonstrated in the example.
 * */
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackMethodExecutionTime {
}

```

#### What annotation will do when we call it at method level
```java
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
```

### After creating above two class How we can use it in out code.

```java
import com.cricketcrickbuzz.advice.TrackMethodExecutionTime;
import io.micrometer.core.annotation.Timed;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Service
public class MatchesHandler {
    
    @TrackMethodExecutionTime
    public Mono<ServerResponse>  getList(ServerRequest serverRequest){
        // Business logic
        return ServerResponse.ok().build();

    }
}

```

### We can implement it at a WebFilter level below given example.
*Note* When we use both functional filter and traditional filter the priority 1 it will handle by Web-filter then it will hit by RouterFunctions.route().filter() method.
```java
// It will automatically track request and make a log for that request.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class GlobalExecutionTimeFilter implements WebFilter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExecutionTimeFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();
        return chain.filter(exchange).doFinally(signal -> {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            logger.info("Request path: {}, Execution time: {} ms", exchange.getRequest().getPath(), executionTime);
        });
    }
}
```

### We can implement it at a RouterFunctions level with minimum code given example.
```java
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
                        )
                ).filter(((request, next) -> {
                    long startTime = System.currentTimeMillis();
                    CustomLogger.logInRequest(request);
                    System.out.println("STEP FILTER " + startTime);
                    return next.handle(request)
                            .doOnSuccess(result -> {
                                long endTime = System.currentTimeMillis();
                                Float executionTime = (endTime - startTime)/1_000f;
                                logger.info("M Request path: {}, Execution time: {} ms", request.exchange().getRequest(), executionTime);
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

```