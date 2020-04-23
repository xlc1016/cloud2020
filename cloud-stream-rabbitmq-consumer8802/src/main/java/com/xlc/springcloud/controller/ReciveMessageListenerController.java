package com.xlc.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(Sink.class)
public class ReciveMessageListenerController {


//
//    @Value("${server.port}")
//    private String  servicePort;
//
//
//
//    @StreamListener(Sink.INPUT)
//    public void reciveMessage(Message<String> message){
//        log.info("消费者1号，-----》 接收到的消息："+message.getPayload()+"\t port:"+servicePort);
//        System.out.println("消费者1号，-----》 接收到的消息："+message.getPayload()+"\t port:"+servicePort);
//
//    }


    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，------->接收到的消息： "+message.getPayload()+"\t port: "+serverPort);
    }
}
