package com.techtalk.webflux.fn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class CustomWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();

        exchange.getResponse()
                .getHeaders().add("web-filter", "web-filter-test-From-Webflux-Demo");
        return chain.filter(
                exchange.mutate().request(
                                exchange.getRequest().mutate()
                                        .header("customer-header", "customer-header-value")
                                        .build())
                        .build()).doFinally(signalType -> {
            long totalTime = System.currentTimeMillis() - startTime;
            exchange.getAttributes().put("totalTime", totalTime);
            System.out.println(totalTime);

        } );
    }
}
