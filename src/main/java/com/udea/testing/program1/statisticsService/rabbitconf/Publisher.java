package com.udea.testing.program1.statisticsService.rabbitconf;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Component
public class Publisher {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitConf.class);
    RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);

//    public void publishMessage(String exchange, String routingKey, String message) {
//        rabbitTemplate.convertAndSend(exchange, routingKey, message);
//    }

    public void publishMessageAsync(String exchange, String routingKey, String message) {
        CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(exchange, routingKey, message));
    }


}

