package com.vidor.springcloudprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.vidor.springcloudcommon.bean.User;
import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private List<User> users = Lists.newArrayList(
            new User(1, "谭浩强", 100, LocalDate.now()),
            new User(2, "严蔚敏", 120, LocalDate.now()),
            new User(3, "谭浩强", 100, LocalDate.now()),
            new User(4, "James Gosling", 150, LocalDate.now()),
            new User(6, "Doug Lea", 150, LocalDate.now())
    );

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return users.stream().map(u -> new User(u.getId(), u.getName(), u.getAge(), u.getDob())).collect(Collectors.toList());
    }

    @GetMapping("/getUserById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        if (id == 2) {
            try {
                Thread.sleep(3000);//hystrix默认1秒算超时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(new User(id,"testing",100,LocalDate.now()), HttpStatus.OK);
    }

    public ResponseEntity<User> hystrixMethod(@PathVariable("id") int id) {
        System.out.println("11111111111111");
        return new ResponseEntity(new User(id,"hystrix",0,LocalDate.now()), HttpStatus.BAD_REQUEST);
    }
}
