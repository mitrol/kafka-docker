package net.mitrol.kafkadockerinfra;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    protected final static String TOPIC_NAME = "kafka_docker_test";

//    @Autowired
//    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//    @Autowired
//    private Receiver receiver;

    @Autowired
    private Sender sender;

    @ClassRule
    public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, TOPIC_NAME);

    @Test
    public void testReceive() throws Exception {
        sender.send(TOPIC_NAME, "Hello Spring Kafka!");
    }
}