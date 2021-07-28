package com.example.kafkasample.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class KafkaConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "test-topic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
            log.info(message);
        }
    }
}
