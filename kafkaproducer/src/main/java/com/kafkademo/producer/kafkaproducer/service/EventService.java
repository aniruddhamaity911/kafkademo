package com.kafkademo.producer.kafkaproducer.service;

import com.kafkademo.producer.kafkaproducer.entity.Product;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@Service
public class EventService {
    private final KafkaTemplate<String, Product> kafkaTemplate;
    public EventService(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean publish(Product product) {
        System.out.println("Publishing product " + product);
        ProducerRecord<String,Product> record = new ProducerRecord<>("product-created-event-topic","product-"+product.getId(),product);
        record.headers().add("messageId", UUID.randomUUID().toString().getBytes());
        CompletableFuture<SendResult<String,Product>> future
                = kafkaTemplate.send(record);
        future.whenComplete((r,e)->{
            if(e!=null){
                System.out.println(e.getStackTrace());
            }
            else {
                System.out.println("message successfully saved");
            }
        });
        future.join();
        System.out.println("Published product");
        return true;
    }
}
