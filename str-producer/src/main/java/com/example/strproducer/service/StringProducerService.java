package com.example.strproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate template;

    public void sendMessage(String message){
        template.send("str-topic",message).addCallback(
                success -> {
                    if(success!=null){
                        log.info("Mensagem enviada com sucesso {}",message);
                    }
                },
                error-> log.info("erro ao enviar a mensagem!"));
    }
}
