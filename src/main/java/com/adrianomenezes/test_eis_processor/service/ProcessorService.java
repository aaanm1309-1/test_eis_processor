package com.adrianomenezes.test_eis_processor.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessorService {

    @Autowired
    private KafkaTemplate<String, String> producer;


    @SneakyThrows
    public void execute(String payload) {

        try {

            if(true)
                executeEvent(payload);
            else
                log.info("Newer event already at database");

            log.info("Event finished for message: " + payload);

        }
        catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    private void executeEvent(String payload) {
        var key = "word_result";
        var record = new ProducerRecord<String, String>("word_result_topic", key, payload.replaceAll("\"",""));

        producer.send(record);
        log.info("Evento Executado");
    }

}

