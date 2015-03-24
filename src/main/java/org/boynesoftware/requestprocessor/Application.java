package org.boynesoftware.requestprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.boynesoftware.requestprocessor.model.SupportRequest;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner {

	final static String queueName = "spring-boot";

	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Receiver receiver;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

	@Bean
	SimpleMessageListenerContainer container(
			ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		System.err.println("About to create container");
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	Receiver receiver() {
		return new Receiver();
	}

	@Bean
	public DefaultClassMapper typeMapper() {
		DefaultClassMapper typeMapper = new DefaultClassMapper();
		Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
		idClassMapping.put("bean",
				SupportRequest.class);
		typeMapper.setIdClassMapping(idClassMapping);
		return typeMapper;
	}

	@Bean
	public MessageConverter messageConverter() {
		JsonMessageConverter jsonMessageConverter = new JsonMessageConverter();
		jsonMessageConverter.setClassMapper(typeMapper());
		return jsonMessageConverter;
	}

	@Bean
	MessageListenerAdapter listenerAdapter() {
		return new MessageListenerAdapter(receiver, messageConverter());
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Waiting five seconds...");
		Thread.sleep(5000);
		System.out.println("Sending message...");
		receiver().getLatch().await(10000, TimeUnit.MILLISECONDS);
		
	}
}
