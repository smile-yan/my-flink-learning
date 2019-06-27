package cn.smileyan.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author smileyan
 */
public class MyProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.112.128:9092");
        props.put("acks", "all");
        props.put("delivery.timeout.ms", 30000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
        int i=0;
        while(i<Integer.MAX_VALUE) {
            JSONObject json = new JSONObject();
            json.put("num",i);
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            json.put("date",dateFormat.format(new Date()));
            kafkaProducer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), json.toString()));

            System.out.println("Sending data: "+json.toString());
            Thread.sleep(1000);
            i++;
        }

        kafkaProducer.close();
    }

}
