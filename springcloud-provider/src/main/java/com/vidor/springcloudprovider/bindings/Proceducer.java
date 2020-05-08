package com.vidor.springcloudprovider.bindings;

import com.vidor.springcloudprovider.channel.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(MySource.class)
public class Proceducer implements CommandLineRunner {

    @Autowired
    @Qualifier(MySource.MYOUTPUT)
    private MessageChannel output;

    @Override
    public void run(String... args) throws Exception {
        output.send(MessageBuilder.withPayload("send a message...").build());
    }
}
