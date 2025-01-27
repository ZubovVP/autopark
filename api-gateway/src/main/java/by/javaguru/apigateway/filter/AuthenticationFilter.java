package by.javaguru.apigateway.filter;

import by.javaguru.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private RouteValidator validator;

    @Autowired
    private JwtUtil jwtUtil;

    public static class Config{

    }

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (validator.isSecured.test(exchange.getRequest())) {
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    return handleError(exchange, "Missing or invalid Authorization header");
                }

                String token = authHeader.substring(7);

                try {
                    jwtUtil.validateToken(token);
                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    return handleError(exchange, "Not Authorized. Access denied: " + e.getMessage());
                }

//                 можно валидировать через identity-service
//            return webClient.build()
//                    .get()
//                    .uri("http://IDENTITY-SERVICE/auth/validate?token=" + token)
//                    .retrieve()
//                    .bodyToMono(String.class)
//                    .flatMap(response -> chain.filter(exchange))
//                    .onErrorResume(e -> handleError(exchange, "Not Authorized. Access denied: " + e.getMessage()));
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> handleError(ServerWebExchange exchange, String error) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().add(HttpHeaders.CONTENT_TYPE, "text/plain");
        DataBufferFactory bufferFactory = exchange.getResponse().bufferFactory();
        DataBuffer buffer = bufferFactory.wrap(error.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }

}
