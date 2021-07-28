package com.example.kafkasample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        kafkaTemplate.send("test-topic", message);
    }
}
