import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) throws Exception{

        String topicName = "SimpleProducerTopic";
        String key = "Key1";
        String value = "YOOOOOOOO so coool";

        Properties props = new Properties();
        props.put("bootstrap.servers", "ec2-18-188-76-12.us-east-2.compute.amazonaws.com:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
        producer.send(record);
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}
