package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "test-queue", containerFactory = "myFactory")
    public void receiveMessage(String email) {

        System.out.println("Received <" + email + ">");
        latch.countDown();
    }

}