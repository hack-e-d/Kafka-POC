package com.hacked.kafkapoc;

import com.hacked.kafkapoc.kafkaProducer.KafkaProducer;
import com.hacked.kafkapoc.models.ChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SendController {

    private final KafkaProducer kafkaProducer;

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);

    public SendController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public String publishToKafkaTopic(@RequestBody List<ChangeEvent> changeEvents) {
        logger.info(changeEvents.toString());
        kafkaProducer.sendMessage(changeEvents);
        return "Sent to topic";
    }
}
