package com.kafkademo.producer.kafkaproducer.controller;

import com.kafkademo.producer.kafkaproducer.entity.Product;
import com.kafkademo.producer.kafkaproducer.service.EventService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private EventService eventService;

    @Autowired
    public ProducerController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = "/publish")
    private void publish(@RequestBody Product product) {
        this.eventService.publish(product);
    }
}
