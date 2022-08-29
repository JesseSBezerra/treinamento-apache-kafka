package br.com.jdsb.paymentservice.resource.impl;

import br.com.jdsb.paymentservice.model.Payment;
import br.com.jdsb.paymentservice.resource.PaymentResource;
import br.com.jdsb.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResouceImpl implements PaymentResource {

    private final PaymentService service;

    @Override
    public ResponseEntity<Payment> payment(Payment paymentBody) {
        service.sendPayment(paymentBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
