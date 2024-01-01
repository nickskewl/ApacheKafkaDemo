package com.nitesh.advance.kafka.service;

import com.nitesh.advance.kafka.payload.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author nitesh
 */
@Service
public class KafkaProducer {

    @Value("${kafka.advance-topic-name}")
    String topicName;

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.message-per-api-request}")
    int messagePerApiRequest;

    public String publish(@PathVariable String message) {
        for (int key = 0; key < messagePerApiRequest; key++) {
            //sending, topicName, Key and message
            kafkaTemplate.send(topicName, String.valueOf(key), new MessageBody(key, message));
        }
        return "Messages Sent - " + messagePerApiRequest + " times: " + message;
    }
}
