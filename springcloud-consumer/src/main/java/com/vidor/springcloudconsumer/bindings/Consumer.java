package com.vidor.springcloudconsumer.bindings;

import com.vidor.springcloudconsumer.channel.MySink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MySink.class)
public class Consumer {

    @StreamListener(MySink.MYINPUT)
    public void input(String message){
        System.out.println("receive message: "+message);
    }
}
