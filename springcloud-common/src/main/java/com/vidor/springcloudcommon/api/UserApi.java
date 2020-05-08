package com.vidor.springcloudcommon.api;

import com.vidor.springcloudcommon.FeignClientConfig;
import com.vidor.springcloudcommon.bean.User;
import com.vidor.springcloudcommon.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "springcloud-zuul", configuration = FeignClientConfig.class, fallbackFactory= DeptClientServiceFallbackFactory.class)
public interface UserApi {

    @GetMapping("zuul-common/api/v1/users/getUsers")
    public List<User> getUsers();

    @GetMapping("zuul-common/api/v1/users/getUserById/{id}")
    public User getUserById(@PathVariable("id") int id);
}