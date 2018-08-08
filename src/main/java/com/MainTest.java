package com;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.cloud.stream.binder.rabbit.provisioning.RabbitExchangeQueueProvisioner;
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter;
import org.springframework.integration.monitor.IntegrationMBeanExporter;

/**
 * @author plus me
 * @date 2018/8/2
 */
public class MainTest {
    private static ConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");


    static {
        AbstractConnectionFactory factory = ((AbstractConnectionFactory) connectionFactory);
        factory.setPassword("guest");
        factory.setUsername("guest");
    }
    private AmqpTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

    public void send() {
        String context = "hello wwx";
        this.rabbitTemplate.convertAndSend("myExchange", "hello.*", context);

    }

    public static void main(String args[]) {
        new MainTest().send();
    }
}
