package com.leolsbufalo.moon.kafka.Producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leolsbufalo.moon.entity.Payment;
import com.leolsbufalo.moon.exception.KafkaSenderException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducer {

    @Value("${kafka.topics.create-payment}")
    private String createPaymentTopic;

    @Autowired
    private KafkaProducer<Integer, String> paymentProducer;


    public Payment send(Payment payment) {
        ProducerRecord<Integer, String> producerRecord = new ProducerRecord<>(createPaymentTopic, payment.getId(), payment.toJson());

        try {
            paymentProducer.send(producerRecord);
            paymentProducer.flush();
            return payment;
        } catch (Exception exception) {
            throw exception;
        }
    }
}
