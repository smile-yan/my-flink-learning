package cn.smileyan.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author smileyan
 */
public class Consumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        // kafka 集群
        props.put("bootstrap.servers", "192.168.112.128:9092");
        // 消费者组ID
        props.put("group.id", "my-topic");
        // 自动提交offset
        props.put("enable.auto.commit", "true");
        //
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        // 订阅，指定topic,单个使用 Collections.singletonList("my-topic")
        // 可以指定多个 topic, Arrays.asList("foo", "bar")
        consumer.subscribe(Collections.singletonList("my-topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }

    }
}
