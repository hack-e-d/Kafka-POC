package com.hacked.kafkapoc.kafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private final String TOPIC_NAME = "kafka-poc-topic";

    @KafkaListener(topics = TOPIC_NAME, groupId = "your-consumer-group-id")
    public void consumeMessage(String message) {
        logger.info("Incoming events : " + message);
    }
}
