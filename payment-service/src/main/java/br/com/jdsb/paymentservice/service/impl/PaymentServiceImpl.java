package br.com.jdsb.paymentservice.service.impl;

import br.com.jdsb.paymentservice.model.Payment;
import br.com.jdsb.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: RECEBI O PAGAMENTO :::{}",payment);
    }
}
