package com.vidor.springcloudconsumer.feign;

import com.vidor.springcloudcommon.FeignClientConfig;
import com.vidor.springcloudcommon.bean.User;
import com.vidor.springcloudcommon.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "springcloud-provider")
public interface UserApi {

    @GetMapping("/api/v1/users/getUsers")
    public List<User> getUsers();

        @GetMapping("/api/v1/users/getUserById/{id}")
    public User getUserById(@PathVariable("id") int id);
}