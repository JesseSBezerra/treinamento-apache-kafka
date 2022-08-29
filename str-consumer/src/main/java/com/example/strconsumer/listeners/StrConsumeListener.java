package com.example.strconsumer.listeners;

import com.example.strconsumer.custom.StrConsumeCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumeListener {

    @StrConsumeCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: mensagem {}",message);
    }

   @StrConsumeCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: mensagem {}",message);
    }

    @StrConsumeCustomListener(groupId = "group-2")
    public void history(String message){
        log.info("HISTORICO ::: mensagem {}",message);
    }
}
