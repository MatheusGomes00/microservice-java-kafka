package com.pb.challangeThree.msNotify.kafkaConsumer.service;

import com.pb.challangeThree.msNotify.kafkaConsumer.entitie.Notify;
import com.pb.challangeThree.msNotify.kafkaConsumer.message.ProcessedRequest;
import com.pb.challangeThree.msNotify.kafkaConsumer.repository.NotifyRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProcessedRequestService {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private NotifyRepository repository;


    @KafkaListener(topics = "${spring.kafka.topics}", groupId = "group_id")
    public void requestListener(ConsumerRecord<String, ProcessedRequest> message, Acknowledgment ack) {
        // logger.info("Received message: {}", message);

        ProcessedRequest processedRequest = message.value();
        String logMessage = String.format("Received message: username=%s, operation=%s",
                processedRequest.getUserName(), processedRequest.getOperation());
        logger.info(logMessage);

        ack.acknowledge();
        logger.info("Acknowledge sended!");

        Notify obj = new Notify();
        obj.setUsername(processedRequest.getUserName());
        obj.setOperation(processedRequest.getOperation());
        obj.setTimestamp(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
                .format(DateTimeFormatter.RFC_1123_DATE_TIME));
        repository.insert(obj);
    }

}
