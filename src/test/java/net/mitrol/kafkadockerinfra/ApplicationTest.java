package net.mitrol.kafkadockerinfra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    private final static String TOPIC_NAME = "kafka_docker_test";
    private final static String MESSAGE = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ¡²³¤€¼½‘’~!@#%$^&*()_+äå®";

    @Autowired
    private Sender sender;

    @Test
    public void testSender() throws Exception {
        sender.send(TOPIC_NAME, MESSAGE);
    }
}