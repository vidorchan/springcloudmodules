package com.vidor.springcloudconsumer.channel;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    String MYINPUT = "myinput";

    @Input(MYINPUT)
    SubscribableChannel input();
}
