package com.kafkademo.producer.kafkaproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String title;
    private String description;

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}
