package cn.kafka.demo.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 描述: spring-kafka
 *
 * @author : lhb
 * @date : 2020-03-12 14:58
 */
@Service
public class SpringKafka implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(SpringKafka.class);

//    @Autowired
//    private KafkaTemplate<String, String> template;
    @Value("${logmessage.topic}")
    private String topic;

//    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
//        this.template.send("test", "foo1");
//        this.template.send("test", "foo2");
//        this.template.send("test", "foo3");
//        latch.await(60, TimeUnit.SECONDS);
//        logger.info("All received");
    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
//        logger.info(cr.toString());

        System.out.println(cr.value());
//        latch.countDown();
    }
}
