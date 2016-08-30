package com.hansong.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * @author hansong.xhs
 * @version $Id: MyConsumer.java, v 0.1 2016-08-27 17:12 hansong.xhs Exp $
 */
public class MyConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    public static void main(String[] args) throws InterruptedException {
        ConsumerConfig config = createConsumerConfig("localhost:2181", "group-1");
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);
        int threads = 1;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("test1", threads);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
            .createMessageStreams(topicCountMap);

        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("test1");
        for (KafkaStream stream : streams) {
            executor.execute(new ConsumerMsgTask(stream));
        }
        //        while (!executor.awaitTermination(10, TimeUnit.SECONDS));
        executor.shutdown();
        logger.info("main stop");

    }

    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }

    static class ConsumerMsgTask implements Runnable {
        private KafkaStream stream;

        ConsumerMsgTask(KafkaStream stream) {
            this.stream = stream;
        }

        public void run() {
            ConsumerIterator<byte[], byte[]> it = stream.iterator();
            while (it.hasNext()) {
                MessageAndMetadata<byte[], byte[]> mam = it.next();
                logger.info("partition: {}, msg: {}", mam.partition(), new String(mam.message()));
            }
        }
    }
}
