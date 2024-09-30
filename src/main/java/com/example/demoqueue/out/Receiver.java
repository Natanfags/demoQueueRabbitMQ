package com.example.demoqueue.out;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receivedMessage(String message) {
        System.out.println(" Received: " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
