package com.nitesh.advance.kafka.service;

import com.nitesh.advance.kafka.payload.MessageBody;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author nitesh
 */
@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    // clientIdPrefix is optional, added here so the logs are more human friendly.
    // In logs, we can see - Kafka messages with the same key are always placed in the same partitions.
    @KafkaListener(topics = "${kafka.advance-topic-name}", clientIdPrefix = "json", containerFactory = "objectKafkaListenerContainerFactory")
    public void listenAsObject(ConsumerRecord<String, MessageBody> cr, @Payload MessageBody payload) {
        LOGGER.info("[JSON] received key {} | Partition: {} | Payload: {} ", cr.key(), cr.partition(), payload);
        LOGGER.info("JSON Message Received: {}", payload);
    }

    @KafkaListener(topics = "${kafka.advance-topic-name}", clientIdPrefix = "string", containerFactory = "stringKafkaListenerContainerFactory")
    public void listenAsString(ConsumerRecord<String, String> cr, @Payload String payload) {
        LOGGER.info("[STRING] received key {} | Partition: {} | Payload: {} ", cr.key(), cr.partition(), payload);
        LOGGER.info("String Message Received: {}", payload);
    }
}
