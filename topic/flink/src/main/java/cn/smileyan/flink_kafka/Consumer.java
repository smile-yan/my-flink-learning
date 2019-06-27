package cn.smileyan.flink_kafka;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer082;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.Properties;

public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.112.128:9092");
        // only required for Kafka 0.8
        properties.setProperty("zookeeper.connect", "192.168.112.128:2181");
        properties.setProperty("group.id", "my-topic");
        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer082<String>("my-topic", new SimpleStringSchema(), properties));
        stream.print();
    }
}
