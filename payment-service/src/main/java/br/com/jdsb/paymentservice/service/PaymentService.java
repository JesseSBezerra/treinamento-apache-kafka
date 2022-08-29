package br.com.jdsb.paymentservice.service;

import br.com.jdsb.paymentservice.model.Payment;

public interface PaymentService {

    public void sendPayment(Payment payment);
}
