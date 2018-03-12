package producer.api.ws;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import producer.api.domain.TaskMessage;

import java.util.Properties;

@Service
public class ProducerService {

    private Properties props = new Properties();

    public ProducerService() {
        props.put("bootstrap.servers", "ec2-18-188-76-12.us-east-2.compute.amazonaws.com:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public void publishTask(TaskMessage taskMessage) {
        String topicName = "SimpleProducerTopic";

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName,taskMessage.getDescription());
        producer.send(record);
    }
}
