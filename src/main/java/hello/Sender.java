package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, String message) {
        System.out.println("sending message=" + message + "to destination=" + destination);
        jmsTemplate.convertAndSend(destination, message);
    }
}
