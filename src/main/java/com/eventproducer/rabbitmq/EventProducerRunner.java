package com.eventproducer.rabbitmq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eventproducer.rabbitmq.model.EventMsg;
import com.eventproducer.rabbitmq.producer.Producer;
import com.eventproducer.rabbitmq.model.RequestedMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventProducerRunner implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EventProducerRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}