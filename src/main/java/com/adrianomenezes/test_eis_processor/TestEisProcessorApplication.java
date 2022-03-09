package com.adrianomenezes.test_eis_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
//@EnableKafkaStreams
public class TestEisProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEisProcessorApplication.class, args);
	}

}
