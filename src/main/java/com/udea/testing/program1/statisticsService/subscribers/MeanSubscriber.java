package com.udea.testing.program1.statisticsService.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsService.model.Node;
import com.udea.testing.program1.statisticsService.model.NumberSet;
import com.udea.testing.program1.statisticsService.rabbitconf.Publisher;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Component
public class MeanSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message) {

        ObjectMapper objectMapper = new ObjectMapper();
        Publisher publisher = new Publisher();
        NumberSet numberSet = null;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);
            numberSet.generateList();
            numberSet.calculateMean();
            numberSet.setList(null);
            publisher.publishMessageAsync("udea.testing.result", "mean", objectMapper.writeValueAsString(numberSet));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
