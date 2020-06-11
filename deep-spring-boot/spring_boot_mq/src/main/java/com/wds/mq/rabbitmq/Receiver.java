package com.wds.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : TenYun
 * @date : 2019-06-18 14:02
 * @description :
 **/
@Component
@RabbitListener(queues = "helloworld")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver: " + hello);
    }
}
