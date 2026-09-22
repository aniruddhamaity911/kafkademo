package com.kafkademo.consumer.kafkaconsumer.config;

import com.kafkademo.consumer.kafkaconsumer.errorhandeling.NorRetryableException;

import com.kafkademo.consumer.kafkaconsumer.errorhandeling.ReTryableException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.retry.RetryException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;


@Configuration
public class ConsumerConfiguration {
    @Bean
    public DefaultErrorHandler errorHandler(KafkaTemplate<Object, Object> kafkaTemplate) {

        DeadLetterPublishingRecoverer recoverer =
                new DeadLetterPublishingRecoverer(kafkaTemplate);

        FixedBackOff backOff = new FixedBackOff(1000L, 2);

        DefaultErrorHandler errorHandler = new DefaultErrorHandler(recoverer, backOff);
        errorHandler.addNotRetryableExceptions(NorRetryableException.class);
        errorHandler.addRetryableExceptions(ReTryableException.class);
        return errorHandler;
    }
}
