package com.adrianomenezes.test_eis_processor.adapter.listener;

import com.adrianomenezes.test_eis_processor.service.ProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProcessorListener {

    @Autowired
    ProcessorService service;

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "${topic.name.processor}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName) {
        log.info("Message received from topic " + topicName + ":" + message);
        service.execute(message);
    }
}
