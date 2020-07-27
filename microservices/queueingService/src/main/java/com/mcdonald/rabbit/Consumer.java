package com.mcdonald.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.mcdonald.repositories.ObjectRepository;

@Component
public class Consumer {
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	private ObjectRepository objRepos;
	
	public Consumer(ObjectRepository repository) {
		this.objRepos = repository;
	}
	
	@RabbitListener(queues = "${store.amqp.queue}")
	public void processCountry(Object o) {
	
	log.info("Consumer> " + o);
	log.info("Country created> " + this.objRepos.save(o));
	}
}
