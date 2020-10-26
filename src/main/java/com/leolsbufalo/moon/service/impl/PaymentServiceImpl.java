package com.leolsbufalo.moon.service.impl;

import com.leolsbufalo.moon.entity.Payment;
import com.leolsbufalo.moon.kafka.Producer.PaymentProducer;
import com.leolsbufalo.moon.repository.PaymentRepository;
import com.leolsbufalo.moon.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentProducer paymentProducer;

    @Override
    public Payment createPayment(Payment payment) {
        try {
            paymentRepository.save(payment);
            return paymentProducer.send(payment);

        } catch (Exception exception) {
            throw exception;
        }

    }
}
