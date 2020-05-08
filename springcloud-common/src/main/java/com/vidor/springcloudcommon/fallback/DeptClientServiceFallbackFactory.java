package com.vidor.springcloudcommon.fallback;

import com.vidor.springcloudcommon.api.UserApi;
import com.vidor.springcloudcommon.bean.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserApi> {

    @Override
    public UserApi create(Throwable throwable) {
        return new UserApi() {
            @Override
            public List<User> getUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                User u = new User(id,"degrade",1,LocalDate.now());
                return u;
            }
        };
    }
}
