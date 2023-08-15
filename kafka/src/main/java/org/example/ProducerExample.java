package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;

public class ProducerExample {
    public static void main(String[] args) {

        String topicName = "topic1";

        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        try {
            KafkaProducer<String, String> producer = new KafkaProducer<>(props);

            for (int i=0;i<10;i++){
                ProducerRecord<String,String> record = new ProducerRecord<>(topicName, Integer.toString(i), "Hello");
                producer.send(record);
                System.out.println("record has been send");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
