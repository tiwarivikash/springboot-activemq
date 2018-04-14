package hello;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringJmsApplicationTest {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Test
    public void testReceive() throws Exception {
        sender.send("test-queue", "{to=info@example.com, body=Hello}");

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        Assertions.assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}