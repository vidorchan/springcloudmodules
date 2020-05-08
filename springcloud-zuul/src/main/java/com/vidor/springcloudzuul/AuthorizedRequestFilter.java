package com.vidor.springcloudzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizedRequestFilter extends ZuulFilter {

//    @Value("${server.port}")
//    private String port;

    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
        // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        // 2、route：在进行路由请求的时候被调用；
        // 3、post：在路由之后发送请求信息的时候被调用；
        // 4、error：出现错误之后进行调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;  // 设置优先级，数字越大优先级越低
    }

    // 该Filter是否要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 表示具体的过滤执行操作
    @Override
    public Object run() throws ZuulException {
//        RequestContext requestContext = RequestContext.getCurrentContext();// 获取当前请求的上下文
//        String auth = "vidor:java";// 认证的原始信息
//        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("UTF-8")));// 进行一个加密的处理
//        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
//        String authHeader = "Basic " + new String(encodeAuth);
//        requestContext.addZuulRequestHeader("Authorization",authHeader);
//        System.out.println("222222222222"+authHeader);
//        return null;
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String parameter = request.getParameter("access-token");
//        if(parameter==null){
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
//        System.out.println("--------"+port);
        return null;
    }
}
