package br.com.jdsb.jsonconsumer.listener;

import br.com.jdsb.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "create-group",containerFactory = "jsonContainerFactory")
    public void antFraude(@Payload Payment payment){
      log.info("Recebi o pagamento {}...",payment.toString());
      Thread.sleep(2000);
      log.info("Validando ant-fraude...");
      Thread.sleep(2000);
      log.info("Compra aprovada");
      Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "pdf-group",containerFactory = "jsonContainerFactory")
    public void gerandoPDF(@Payload Payment payment){
        log.info("gerando PDF do produto id {}...",payment.getId());
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "emali-group",containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment){
        log.info("Enviando Email ao usuário de código {}...",payment.getIdUser());
        Thread.sleep(3000);
    }
}
