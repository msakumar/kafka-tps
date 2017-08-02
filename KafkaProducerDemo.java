package com.gap.kafka.test;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
//    		long startTime = System.currentTimeMillis();
        Properties properties = new Properties();

        // kafka bootstrap server
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // producer acks
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);


//        for (int key=0; key < 250000; key++){
        for (int key=0; key < 1000; key++){
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<String, String>("gapStoreTrans3", Integer.toString(key), "message that has key: " + Integer.toString(key));
            producer.send(producerRecord);
        }



        producer.close();
//        long endTime   = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
    }
}
