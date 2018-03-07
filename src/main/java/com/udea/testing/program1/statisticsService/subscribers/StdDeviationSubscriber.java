package com.udea.testing.program1.statisticsService.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsService.model.NumberSet;
import com.udea.testing.program1.statisticsService.rabbitconf.Publisher;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StdDeviationSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        Publisher publisher = new Publisher();
        NumberSet numberSet = null;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);
            Double mean = 0.0;
            for (Double d : numberSet.getSet())
                mean = mean + d;
            mean = mean / numberSet.getSet().size();
            numberSet.setMean(mean);

            Double stdDeviation = 0.0;
            for (Double d : numberSet.getSet()) {
                stdDeviation = stdDeviation + Math.pow(d - mean, 2);
            }
            stdDeviation = Math.sqrt(stdDeviation / numberSet.getSet().size() - 1);

            numberSet.setStdDeviation(stdDeviation);

            publisher.publishMessageAsync("udea.testing.result", "stddeviation", objectMapper.writeValueAsString(numberSet));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String("lastd  " + message.getMessageProperties()));
    }
}
