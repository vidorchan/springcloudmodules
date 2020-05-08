package com.vidor.springcloudprovider.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.MessageChannel;

public interface MySource {
    String MYOUTPUT = "myoutput";

    @Output("myoutput")
    MessageChannel output();
}
