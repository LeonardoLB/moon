package com.leolsbufalo.moon.kafka;

import com.leolsbufalo.moon.entity.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConf {

    Properties props = new Properties();

    @Bean
    public KafkaProducer config() {

        props.put("bootstrap.servers", "moon-kafka:9092");
        props.put("key.serializer", IntegerSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        return new KafkaProducer(props);
    }


}
