# KafkaDemo
Kafka生产者和消费者demo

# Kafka配置属性

http://kafka.apache.org/documentation/#producerconfigs

# 生产者

 Properties props = new Properties();<br>  
 props.put("bootstrap.servers", "localhost:9092");<br>
 props.put("acks", "all");<br>
 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");<br>
 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");<br>

 Producer<String, String> producer = new KafkaProducer<>(props);<br>
 for (int i = 0; i < 100; i++)<br>
     producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));<br>

 producer.close();<br>

# 消费者

 Properties props = new Properties();<br>
     props.setProperty("bootstrap.servers", "localhost:9092");<br>
     props.setProperty("group.id", "test");<br>
     props.setProperty("enable.auto.commit", "true");<br>
     props.setProperty("auto.commit.interval.ms", "1000");<br>
     props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");<br>
     props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");<br>
     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);<br>
     consumer.subscribe(Arrays.asList("foo", "bar"));<br>
     while (true) {<br>
         ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));<br>
         for (ConsumerRecord<String, String> record : records)<br>
             System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());<br>
     }<br>

