package com.kafkademo.consumer.kafkaconsumer.errorhandeling;

public class ReTryableException extends RuntimeException {
    public ReTryableException(Throwable cause) {
        super(cause);
    }

    public ReTryableException(String message) {
        super(message);
    }
}
