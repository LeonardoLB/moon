package com.leolsbufalo.moon.kafka.Producer;

import com.leolsbufalo.moon.entity.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;

public class PaymentProducer {

    @Value("${kafka.topics.create-payment}")
    private String createPaymentTopic;

    private KafkaProducer<Integer, Payment> paymentProducer;


    public Payment send(Payment payment) {
        ProducerRecord producerRecord = new ProducerRecord<Integer, Payment>(createPaymentTopic, payment.getId(), payment);

        try {
            paymentProducer.send(producerRecord);
        } catch (Exception exception) {
            throw exception;
        }

        paymentProducer.close();
        return payment;
    }
}
