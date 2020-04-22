package com.xlc.springcloud.filter;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
* @author :xlc
* @date: 2020-4-22
* @description:
*/
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*************************MyLogGatewayFilter:"+ IdUtil.simpleUUID());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");//每次进来后判断带不带uname这个key
        if (uname == null){
            log.info("非法用户，( ▼-▼ )");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
