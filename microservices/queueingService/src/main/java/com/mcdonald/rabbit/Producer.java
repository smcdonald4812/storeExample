package com.mcdonald.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	private RabbitTemplate template;

	public Producer(RabbitTemplate template) {
		this.template = template;
	}

	public void sendTo(String queue, Object o) {
		this.template.convertAndSend(queue, o);
		log.info("Producer> Message Sent");
	}
}
