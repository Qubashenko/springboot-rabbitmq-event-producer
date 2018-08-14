package com.eventproducer.rabbitmq.producer;

import com.eventproducer.rabbitmq.model.EventMsg;
import com.eventproducer.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
    private EventMsg eventMsg;
	
	@Value("${ep.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${ep.rabbitmq.routingkey}")
	private String routingkey;

	public void produce(EventMsg eventMsg){
		amqpTemplate.convertAndSend(exchange, routingkey, eventMsg);
	}

}
