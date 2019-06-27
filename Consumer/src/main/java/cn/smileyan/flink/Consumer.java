package cn.smileyan.flink;

import java.util.Properties;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import com.alibaba.fastjson.JSONObject;



public class Consumer {
    public static void main(String[] args) throws InterruptedException {
    	System.out.println("Begin");
    	
    	final StreamExecutionEnvironment environment = StreamExecutionEnvironment
    		      .getExecutionEnvironment();
    	final String topic = "my-topic";
    	Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.112.128:9092");
        // only required for Kafka 0.8
        properties.setProperty("zookeeper.connect", "192.168.112.128:2181");
        properties.setProperty("group.id", "1");
        
        FlinkKafkaConsumer011<String> consumer = new FlinkKafkaConsumer011<>(
        	      topic, new SimpleStringSchema(), properties);

//	    DataStreamSource<String> dataStreamSource = environment.addSource(consumer);
//	    dataStreamSource.print();
        
        @SuppressWarnings("unused")
		DataStream<String> dataStream = environment.addSource(consumer)
        								.map(new MapFunction<String, String>() {
											
											/**
											 * 
											 */
											private static final long serialVersionUID = 1L;

											@Override
											public String map(String value) throws Exception {
												JSONObject jsonObject = JSONObject.parseObject(value);
												String value1 = jsonObject.get("date").toString();
												String value2 =  jsonObject.get("num").toString();
												System.out.println("date == "+value1+"	"+"num == "+value2);
												return value;
											}
										});
//        dataStream.print();
	    // 执行操作
	    try {
			environment.execute("Count Num");
		} catch (Exception e) {
			e.printStackTrace();
		}
   	
    }
} 