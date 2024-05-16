package com.hacked.kafkapoc.kafkaProducer;

import com.hacked.kafkapoc.models.ChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC_NAME = "kafka-poc-topic";

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(List<ChangeEvent> changeEvents) {
        kafkaTemplate.send(TOPIC_NAME, UUID.randomUUID().toString(), changeEvents.toString());
        logger.info("Trying to send data : " + changeEvents.toString() + " On topic : " + TOPIC_NAME);
    }
}
