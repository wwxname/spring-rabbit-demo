package com;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 1,2,3是订阅分布模式写法
 * @author plus me
 * @date 2018/8/2
 */
@Component
@RabbitListener(bindings = {@QueueBinding(key = "hello1", value = @Queue(name = "hello.1"), exchange = @Exchange(name = "myExchange", type = ExchangeTypes.FANOUT))})
public class Receiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.err.println("receiver1:" + hello);
    }
}

@Component
@RabbitListener(bindings = {@QueueBinding(key = "hello2", value = @Queue(name = "hello.2"), exchange = @Exchange(name = "myExchange", type = ExchangeTypes.FANOUT))})
class Receiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.err.println("receiver2:" + hello);
    }
}

@Component
@RabbitListener(bindings = {@QueueBinding(key = "hello3", value = @Queue(name = "hello.3"), exchange = @Exchange(name = "myExchange", type = ExchangeTypes.FANOUT))})
class Receiver3 {
    @RabbitHandler
    public void process(String hello) {
        System.err.println("receiver3:" + hello);
    }
}

@Component
@RabbitListener(queuesToDeclare = {@Queue(value = "hello.4")})
class Receiver4 {
    @RabbitHandler
    public void process(String hello) {
        System.err.println("receiver4:" + hello);
    }
}