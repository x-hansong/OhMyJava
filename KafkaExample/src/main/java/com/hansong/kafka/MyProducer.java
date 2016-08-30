package com.hansong.kafka;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * @author hansong.xhs
 * @version $Id: MyProducer.java, v 0.1 2016-08-27 16:41 hansong.xhs Exp $
 */
public class MyProducer {
    private static final Logger logger = LoggerFactory.getLogger(MyProducer.class);

    public static void main(String[] args) {
        Random random = new Random();
        int events = 10;

        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        // key.serializer.class默认为serializer.class
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        // 可选配置，如果不配置，则使用默认的partitioner
        props.put("partitioner.class", "com.hansong.kafka.SimplePartitioner");
        // 触发acknowledgement机制，否则是fire and forget，可能会引起数据丢失
        // 值为0,1,-1,可以参考
        // http://kafka.apache.org/08/configuration.html
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);
        long start = System.currentTimeMillis();
        for (int i = 0; i < events; i++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + random.nextInt(255);
            String msg = runtime + ", blog.xiaohansong.com, " + ip;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("test1", ip, msg);
            producer.send(data);
        }
        logger.info("耗时：{}", System.currentTimeMillis() - start);
        producer.close();
    }
}
