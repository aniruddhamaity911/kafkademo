package com.kafkademo.consumer.kafkaconsumer.errorhandeling;

public class NorRetryableException extends RuntimeException {

    public NorRetryableException(String message) {
        super(message);
    }

    public NorRetryableException(Throwable cause) {
        super(cause);
    }
}
