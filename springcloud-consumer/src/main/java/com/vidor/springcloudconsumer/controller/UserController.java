package com.vidor.springcloudconsumer.controller;

import com.vidor.springcloudcommon.bean.User;
import com.vidor.springcloudconsumer.feign.UserApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiParamImplicitL：一个请求参数
 * @ApiParamsImplicit 多个请求参数
 */
@RestController
public class UserController {

    @Autowired
    private UserApi userApi;  //调用服务的时候，会执行拦截器

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ApiIgnore
    @GetMapping("/v1/users/getUsers")
    public List<User> getUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        String url = "http://localhost:8881/";
        User[] u = restTemplate.getForObject(url, User[].class);
        return Arrays.asList(u);
    }

    @ApiOperation(value="Get a User", notes="get a user")
    @GetMapping("/v1/users/getUser/{id}")
    public User getUserById(@PathVariable("id") int id){
        System.out.println("1111111111"+httpServletRequest.getHeader("Authorization"));
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-provider");
        System.out.println("---"+serviceInstance.getServiceId()+serviceInstance.getHost()+serviceInstance.getPort());
        String url = "http://"+serviceInstance.getServiceId()+"/api/v1/users/getUserById/"+id;
//        User u = restTemplate.getForObject(url, User.class);
        User u = userApi.getUserById(id);
        return u;

    }
}
