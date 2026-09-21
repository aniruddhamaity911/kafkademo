package com.kafkademo.consumer.kafkaconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    private String id;
    private String title;
    private String description;

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}
