package br.com.jdsb.paymentservice.service.impl;

import br.com.jdsb.paymentservice.model.Payment;
import br.com.jdsb.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> template;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento :::{}",payment);
        Thread.sleep(1000);
        log.info("Enviando o pagamento ::");
        template.send("payment-topic",payment);
    }
}
