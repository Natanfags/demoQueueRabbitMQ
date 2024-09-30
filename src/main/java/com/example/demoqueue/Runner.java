package com.example.demoqueue;

import com.example.demoqueue.out.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sengind message ...");
        rabbitTemplate.convertAndSend(DemoQueueApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ");
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
