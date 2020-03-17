package com.stip.net.swagger;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * Author: chenjunan
 * Date: 2019/4/29 12:47
 * Content:
 */
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME,"").build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();

            return chain.filter(newExchange);
        };
    }
}
