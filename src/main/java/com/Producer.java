package com;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author plus me
 * @date 2018/8/2
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //@PostConstruct
    public void send() {
        String context = "hello wwx";
        this.rabbitTemplate.convertAndSend("hello.*", context);
        System.err.println("发送完毕");

    }
}
