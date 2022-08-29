package com.example.strconsumer.listeners;

import com.example.strconsumer.custom.StrConsumeCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumeListener {
    @SneakyThrows
    @StrConsumeCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: mensagem {}",message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

   @StrConsumeCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: mensagem {}",message);
    }

    @KafkaListener(groupId = "group-2",topics = "str-topic",containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("HISTORICO ::: mensagem {}",message);
    }
}
