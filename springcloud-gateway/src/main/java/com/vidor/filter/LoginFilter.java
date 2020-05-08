package com.vidor.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoginFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //ServerWebExchange相当于请求与响应的上下文
        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
//        if (token==null){
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();//请求结束
//        }
        return chain.filter(exchange);//继续执行
    }

    /**
     * 值越小，执行优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
