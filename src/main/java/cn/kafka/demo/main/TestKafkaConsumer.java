package cn.kafka.demo.main;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @BelongsProject: MavenProjectDemo
 * @BelongsPackage: cn.kafka.demo
 * @Author: lhb
 * @CreateTime: 2019-10-15 17:48
 * @Description:
 */
public class TestKafkaConsumer {

    /**
     * 查看配置：http://kafka.apache.org/documentation/#producerconfigs
     *
     * @param args
     */
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "132.121.132.219:9092");
        props.setProperty("group.id", "test-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        //需要订阅 Topic，subscribe() 方法接受一个主题列表作为参数：
//        consumer.subscribe(Collections.singletonList("itmpAnalysisAuto"));
        consumer.subscribe(Collections.singletonList("itmpAnalysisAuto"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
//                    if (record.value().contains("ping_result1")) {
                        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//                    }
                }
            }
        } finally {
            // 关闭消费者,网络连接和 socket 也会随之关闭，并立即触发一次再均衡
            consumer.close();
        }
    }
}
