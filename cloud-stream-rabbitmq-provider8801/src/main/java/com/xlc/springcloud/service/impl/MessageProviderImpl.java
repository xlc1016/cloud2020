package com.xlc.springcloud.service.impl;

import com.xlc.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {


    @Resource
    private MessageChannel output; //  发送消息通道

    @Override
    public String sendMessage() {
        String message= UUID.randomUUID().toString() ;

        output.send(MessageBuilder.withPayload(message).build());
        log.info("发送消息是："+ message);
        return null ;
    }
}
