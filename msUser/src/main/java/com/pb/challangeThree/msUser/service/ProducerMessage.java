package com.pb.challangeThree.msUser.service;

import com.pb.challangeThree.msUser.record.ProcessedRequest;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerMessage {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, ProcessedRequest> kafkaTemplate;
    private final String topic;

    public ProducerMessage(KafkaTemplate<String, ProcessedRequest> kafkaTemplate,
                    @Value("${spring.kafka.topics}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(ProcessedRequest message) {
        logger.info("Send message to topic {}...", topic);
        kafkaTemplate.send(topic, message);
        logger.info("Message send to the topic {}!", topic);
    }
}
