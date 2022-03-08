package com.adrianomenezes.test_eis_processor.api.controller;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/words")
public class Client {

    @Autowired
    private KafkaTemplate<String, String> producerRecord;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> sendWords( @Valid @RequestParam(value = "word") String word) {

        var key = "word";
        var record = new ProducerRecord<String, String>("word_topic", key, word);
//        Callback callback = (data, ex) -> {
//            if (ex != null) {
//                ex.printStackTrace();
//                return;
//            }
//            System.out.println("Mensagem enviada com sucesso para: " + data.topic() + " | partition " + data.partition() + "| offset " + data.offset() + "| tempo " + data.timestamp());
//        };

        producerRecord.send(record);

        return ResponseEntity.ok().body(word);
    }

}
