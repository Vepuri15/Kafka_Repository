package com.example.consumer;

import com.example.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    Logger log = LoggerFactory.getLogger(KafkaAvroConsumer.class);

    @Value("${topic.name}")
    private String topicName;

    @KafkaListener(topics ="${topic.name}")
    public void readMessages(ConsumerRecord<String, Employee> consumerRecord){

        String key =consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro message is received :"+ "Key = "+ key + " Value = "+employee.toString());

    }
}
