package com.kafkademo.consumer.kafkaconsumer.service;

import com.kafkademo.consumer.kafkaconsumer.entity.ProductEvent;
import com.kafkademo.consumer.kafkaconsumer.errorhandeling.NorRetryableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = {"product-created-event-topic"})
public class ProductEventHandler {
    private static  final Logger LOG = LoggerFactory.getLogger(ProductEventHandler.class);

    @KafkaHandler
    private void handle(ProductEvent event){
        if(event.getId() == null || event.getId().equals("")|| event.getId().isEmpty()){
            throw new NorRetryableException("id is empty");
        }
        LOG.info("{} event is arrived",event);

    }
//    @KafkaHandler
//    private void handle(String message){
//        LOG.info("{} event is arrived",message);
//
//    }
}
