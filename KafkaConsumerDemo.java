package com.gap.kafka.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerDemo implements Runnable {
	private KafkaStream m_stream;
    private int m_threadNumber;
 
    public KafkaConsumerDemo(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext())
            System.out.println("Thread " + m_threadNumber + ": " + new String(it.next().message()));
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
    
    public static void main(String[] args) {
        Properties properties = new Properties();

        // kafka bootstrap server
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", "test");
        properties.setProperty("enable.auto.commit", "false");
//        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("auto.offset.reset", "earliest");
//        properties.setProperty("auto.offset.reset", "latest");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList("gapStoreTrans3"));

        while(true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(10);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//                consumerRecord.value();
//                consumerRecord.key();
//                consumerRecord.offset();
//                consumerRecord.partition();
//                consumerRecord.topic();
//                consumerRecord.timestamp();

                System.out.println("Partition: " + consumerRecord.partition() +
                                    ", Offset: " + consumerRecord.offset() +
                                    ", Key: " + consumerRecord.key() +
                                    ", Value: " + consumerRecord.value());

            }
            kafkaConsumer.commitSync();
        }

    }

}
