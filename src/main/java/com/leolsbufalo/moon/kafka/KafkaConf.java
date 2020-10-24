package com.leolsbufalo.moon.kafka;

import com.leolsbufalo.moon.entity.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConf {

    Properties props = new Properties();

    public KafkaProducer config(Payment payment) {

        props.put("bootstrap.servers", "moon-kafka:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer(props);
    }


}
