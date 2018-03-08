package com.udea.testing.program1.statisticsService.rabbitconf;


import com.udea.testing.program1.statisticsService.subscribers.MeanSubscriber;
import com.udea.testing.program1.statisticsService.subscribers.StdDeviationSubscriber;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Configuration
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("clam.rmq.cloudamqp.com");
        cachingConnectionFactory.setUsername("vmwickmf");
        cachingConnectionFactory.setPassword("j9oXPZOMCS75yX0HMtmw14EfBQXArq9U");
        //cachingConnectionFactory.setPort(5672);
        cachingConnectionFactory.setVirtualHost("vmwickmf");
        cachingConnectionFactory.setChannelCheckoutTimeout(10000);
        cachingConnectionFactory.setRequestedHeartBeat(30);
        return cachingConnectionFactory;
    }


    @Bean
    public SimpleMessageListenerContainer containerMean(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.setQueueNames("udea.testing.calculate.mean");
        messageListenerContainer.setMessageListener(new MeanSubscriber());
        messageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return messageListenerContainer;
    }

    @Bean
    public SimpleMessageListenerContainer containerstdDeviation(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.setQueueNames("udea.testing.calculate.stddeviation");
        messageListenerContainer.setMessageListener(new StdDeviationSubscriber());
        messageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return messageListenerContainer;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }
}
