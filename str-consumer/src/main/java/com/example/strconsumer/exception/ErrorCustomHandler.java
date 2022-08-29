package com.example.strconsumer.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("EXCEPTION HANDLER::: Capturei um erro");
        log.info("Payload ::: {}",message.getPayload());
        log.info("Headers ::: {}",message.getHeaders());
        log.info("OffSet ::: {}",message.getHeaders().get("kafka_offset"));
        log.error("Exception {}",e.getMessage());
        return null;
    }


    /*
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        return null; // KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }

     */

}
